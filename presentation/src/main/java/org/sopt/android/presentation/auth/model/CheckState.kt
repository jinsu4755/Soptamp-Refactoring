package org.sopt.android.presentation.auth.model

enum class CheckState(
    val isPass: Boolean?
) {
    PASS(null),
    NONE_PASS(false),
    NONE(true);
}
