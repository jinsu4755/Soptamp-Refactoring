package org.sopt.android.presentation.auth.login

import org.sopt.android.presentation.auth.model.LoginUiModel

sealed class LoginState {
    object Loading : LoginState()
    data class Default(val uiModel: LoginUiModel) : LoginState()
    object Failure : LoginState()
}
