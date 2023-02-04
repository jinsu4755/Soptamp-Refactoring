package org.sopt.android.designsystem.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.android.designsystem.component.utils.noRippleClickable
import org.sopt.android.designsystem.style.SoptampTheme

@Composable
fun ErrorDialog(
    title: String,
    content: String? = null,
    retryButtonText: String = "확인",
    onRetry: () -> Unit = {}
) {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(
                text = title,
                style = SoptampTheme.typography.sub1,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        text = {
            content?.let {
                Text(
                    text = it,
                    style = SoptampTheme.typography.caption3,
                    color = SoptampTheme.colors.onSurface50,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        },
        buttons = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFFFF8080))
                    .noRippleClickable { onRetry() }
                    .padding(vertical = 15.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = retryButtonText,
                    style = SoptampTheme.typography.sub1,
                    color = Color.White
                )
            }
        }
    )
}

@Preview
@Composable
fun PreviewErrorDialog() {
    SoptampTheme {
        ErrorDialog(
            title = "네트워크가 원할하지 않습니다.",
            content = "인터넷 연결을 확인하고 다시 시도해 주세요."
        )
    }
}
