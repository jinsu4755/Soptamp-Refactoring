package org.sopt.android.presentation.auth.model

import org.sopt.android.domain.utils.CheckState
import org.sopt.android.domain.utils.toEmail
import org.sopt.android.domain.utils.toNickName
import org.sopt.android.domain.utils.toPassword

data class RegisterUiModel(
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
    val isCheckNickname: Boolean = false,
    val isCheckEmail: Boolean = false
) {

    fun updateNickname(value: String): RegisterUiModel {
        val nickname = value.toNickName()
        return copy(
            nickname = nickname.value,
            nicknameCheckState = if (value.isEmpty() or nickname.isValid) CheckState.NONE else CheckState.NONE_PASS,
            nicknameCheckMessage = nickname.errorMessage
        )
    }

    fun updateEmail(value: String): RegisterUiModel {
        val email = value.toEmail()
        return copy(
            email = email.value,
            emailCheckState = if (value.isEmpty() or email.isValid) CheckState.NONE else CheckState.NONE_PASS,
            emailCheckMessage = email.errorMessage
        )
    }

    fun updatePassword(value: String): RegisterUiModel {
        val password = value.toPassword()
        return copy(
            password = password.value,
            passwordCheckState = if (value.isEmpty() or password.isValid) CheckState.NONE else CheckState.NONE_PASS,
            passwordCheckMessage = password.errorMessage
        )
    }

    fun updatePasswordConfirm(value: String): RegisterUiModel {
        val isEqualPassword = (value == password)
        return copy(
            passwordConfirm = value,
            passwordConfirmCheckState = if (value.isEmpty() or isEqualPassword) {
                CheckState.NONE
            } else {
                CheckState.NONE_PASS
            },
            passwordCheckMessage = if (isEqualPassword) {
                ""
            } else {
                NOT_EQUAL_PASSWORD_MESSAGE
            }
        )
    }

    companion object {
        val empty = RegisterUiModel()
        private const val NOT_EQUAL_PASSWORD_MESSAGE = "비밀번호가 일치하지 않습니다"
    }
}
