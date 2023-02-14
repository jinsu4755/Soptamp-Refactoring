package org.sopt.android.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.android.domain.error.Error
import org.sopt.android.domain.repository.AuthRepository
import org.sopt.android.domain.repository.UserRepository
import org.sopt.android.presentation.auth.model.LoginUiModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _state: MutableStateFlow<LoginState> = MutableStateFlow(LoginState.Default(LoginUiModel.empty))
    val state = _state.asStateFlow()

    fun putEmail(email: String) {
        _state.update { prevState ->
            check(prevState is LoginState.Default)
            prevState.copy(
                uiModel = prevState.uiModel.copy(email = email)
            )
        }
    }

    fun putPassword(password: String) {
        _state.update { prevState ->
            check(prevState is LoginState.Default)
            prevState.copy(
                uiModel = prevState.uiModel.copy(password = password)
            )
        }
    }

    fun login() {
        val email = (state.value as LoginState.Default).uiModel.email
        val password = (state.value as LoginState.Default).uiModel.password
        _state.value = LoginState.Loading
        viewModelScope.launch {
            authRepository.login(
                email,
                password
            ).onSuccess {
                userRepository.setUserId(it.userId)
                userRepository.setUserMessage(it.profileMessage)
                updateCompleteLogin()
            }.onFailure {
                when (it) {
                    is Error.NetWorkUnavailable -> {
                        _state.value = LoginState.Failure
                    }

                    is Error.BadRequest -> {
                        showErrorState(email, password)
                        Timber.tag("Test").d(_state.value.toString())
                    }
                }
            }
        }
    }

    private fun updateCompleteLogin() {
        val successUiModel = LoginUiModel(
            isComplete = true,
            isError = false
        )
        _state.value = LoginState.Default(successUiModel)
    }

    private fun showErrorState(email: String, password: String) {
        val updatedUiModel = LoginUiModel(
            email = email,
            password = password,
            errorMessage = "아이디/비밀번호를 확인해주세요.",
            isComplete = false,
            isError = true
        )
        _state.value = LoginState.Default(updatedUiModel)
    }
}
