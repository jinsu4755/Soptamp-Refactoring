package org.sopt.android.domain.utils

data class Password(
    val value: String
) : Verifiable() {
    val isValid: Boolean = valid(PASSWORD_REGEX.toRegex(), value)
    val errorMessage: String = if (isValid) "" else INVALID_PASSWORD_MESSAGE

    companion object {
        @JvmStatic
        val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#\$%^&*]).{8,16}\$"
        const val INVALID_PASSWORD_MESSAGE = "비밀번호는 영문, 숫자, 특수문자 포함 8-16자여야 합니다."
    }
}

fun String.toPassword() = Password(this)
