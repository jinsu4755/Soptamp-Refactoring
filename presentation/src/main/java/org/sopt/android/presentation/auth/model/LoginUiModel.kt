package org.sopt.android.presentation.auth.model

class LoginUiModel(
    val email: String = "",
    val password: String = "",
    val errorMessage: String? = null,
    val isComplete: Boolean = false,
    val isError: Boolean = false
) {
    companion object {
        val empty = LoginUiModel()
    }
}
