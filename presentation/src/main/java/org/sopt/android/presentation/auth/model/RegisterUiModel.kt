package org.sopt.android.presentation.auth.model

class RegisterUiModel(
    val nickname: String = "",
    val nicknameCheckState: CheckState = CheckState.NONE,
    val nicknameCheckMessage: String = "",
    val email: String = "",
    val emailCheckState: CheckState = CheckState.NONE,
    val emailCheckMessage: String = "",
    val password: String = "",
    val passwordCheckState: CheckState = CheckState.NONE,
    val passwordConfirm: String = "",
    val passwordConfirmCheckState: CheckState = CheckState.NONE,
    val passwordCheckMessage: String = "",
    val errorMessage: String? = null,
    val isAllInputNotEmpty: Boolean = false,
    val isComplete: Boolean = false,
    val isError: Boolean = false
) {
    companion object {
        val empty = RegisterUiModel()
    }
}
