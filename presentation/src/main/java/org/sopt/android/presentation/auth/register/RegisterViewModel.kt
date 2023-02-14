package org.sopt.android.presentation.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.android.domain.repository.AuthRepository
import org.sopt.android.domain.utils.CheckState
import org.sopt.android.presentation.auth.model.RegisterUiModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _state: MutableStateFlow<RegisterState> = MutableStateFlow(RegisterState.Default(RegisterUiModel.empty))
    val state = _state.asStateFlow()

    fun putNickname(nickname: String) {
        _state.update { prevState ->
            check(prevState is RegisterState.Default)
            prevState.copy(
                uiModel = prevState.uiModel.updateNickname(nickname)
            )
        }
    }

    fun putEmail(email: String) {
        _state.update { prevState ->
            check(prevState is RegisterState.Default)
            prevState.copy(
                uiModel = prevState.uiModel.updateEmail(email)
            )
        }
    }

    fun putPassword(password: String) {
        _state.update { prevState ->
            check(prevState is RegisterState.Default)
            prevState.copy(
                uiModel = prevState.uiModel.updatePassword(password)
            )
        }
    }

    fun putPasswordConfirm(passwordConfirm: String) {
        _state.update { prevState ->
            check(prevState is RegisterState.Default)
            prevState.copy(
                uiModel = prevState.uiModel.updatePasswordConfirm(passwordConfirm)
            )
        }
    }

    fun checkNickName(nickname: String) {
        viewModelScope.launch {
            authRepository.checkEmail(nickname)
                .onSuccess { }
        }
    }

    private fun updateNickNamePassState() {
        _state.update { prevState ->
            check(prevState is RegisterState.Default)
            prevState.copy(
                uiModel = prevState.uiModel.copy(
                    nicknameCheckMessage = "사용 가능한 이름입니다.",
                    nicknameCheckState = CheckState.PASS,
                    isCheckNickname = true
                )
            )
        }
    }

    private fun updateEmailPassState() {
        _state.update { prevState ->
            check(prevState is RegisterState.Default)
            prevState.copy(
                uiModel = prevState.uiModel.copy(
                    emailCheckMessage = "사용 가능한 이메일입니다.",
                    emailCheckState = CheckState.PASS,
                    isCheckEmail = true
                )
            )
        }
    }
}
