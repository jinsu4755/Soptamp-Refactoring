package org.sopt.android.domain.utils

data class Email(
    val value: String
) : Verifiable() {
    val isValid: Boolean = valid(EMAIL_REGEX.toRegex(), value)
    val errorMessage: String = if (isValid) "" else INVALID_EMAIL_MESSAGE

    companion object {
        @JvmStatic
        val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        const val INVALID_EMAIL_MESSAGE = "잘못된 이메일 형식입니다."
    }
}

fun String.toEmail() = Email(this)
