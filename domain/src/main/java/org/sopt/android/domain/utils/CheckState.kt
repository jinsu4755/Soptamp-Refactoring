package org.sopt.android.domain.utils

enum class CheckState(
    val isPass: Boolean
) {
    PASS(true),
    NONE_PASS(false),
    NONE(true);
}
