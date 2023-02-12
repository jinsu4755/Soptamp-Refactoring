package org.sopt.android.designsystem.component.dialog

import androidx.compose.runtime.Composable

@Composable
fun NetworkErrorDialog(
    onRetry: () -> Unit = {}
) {
    ErrorDialog(
        title = "네트워크가 원활하지 않습니다.",
        onRetry = { onRetry() }
    )
}
