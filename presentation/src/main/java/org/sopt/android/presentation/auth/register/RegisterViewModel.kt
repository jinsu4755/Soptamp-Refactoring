package org.sopt.android.presentation.auth.register

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.android.presentation.auth.model.RegisterUiModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {
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
}
