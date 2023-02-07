package org.sopt.android.domain.utils

abstract class Verifiable {
    protected fun valid(validateRegex: Regex, value: String): Boolean {
        return validateRegex.matches(value)
    }
}
