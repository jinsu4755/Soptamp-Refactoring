package org.sopt.android.presentation.auth

import org.sopt.android.presentation.auth.model.RegisterUiModel

sealed class RegisterState {
    object Loading : RegisterState()
    data class Default(val uiModel: RegisterUiModel) : RegisterState()
    object Failure : RegisterState()
}
