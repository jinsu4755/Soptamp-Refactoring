package org.sopt.android.domain.utils

data class Nickname(
    val value: String
) : Verifiable() {
    val isValid: Boolean = valid(NICKNAME_REGEX.toRegex(), value)
    val errorMessage: String = if (isValid) "" else INVALID_NICKNAME_MESSAGE

    companion object {
        @JvmStatic
        val NICKNAME_REGEX = "^[A-Za-z가-힣]{0,11}$"
        const val INVALID_NICKNAME_MESSAGE = "한글/영문 11자로 입력해주세요."
    }
}

fun String.toNickName() = Nickname(this)
