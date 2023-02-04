// Write By jinsu4755

package org.sopt.android.designsystem.component.button

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.android.designsystem.style.SoptampTheme

/**
 * Soptamp Floating Button
 * @param icon 기존 ExtendedFloating Button 에서 icon 이 들어가는 것과 동일합니다.
 * @param text 기존 Extended Floating Button 에서 들어가는 text와 동일 합니다, Soptamp 의 Typography 를 적용한 것과 동일합니다.
 * @param onClick 버튼을 눌러 동작할 Listener 를 등록합니다.
 * */
@Composable
fun SoptampFloatingButton(
    icon: @Composable () -> Unit = {},
    text: String,
    onClick: () -> Unit = {}
) {
    ExtendedFloatingActionButton(
        text = {
            Text(
                text = text,
                color = SoptampTheme.colors.white,
                style = SoptampTheme.typography.h2
            )
        },
        icon = { icon() },
        onClick = { onClick() },
        shape = RoundedCornerShape(46.dp),
        backgroundColor = SoptampTheme.colors.purple300,
        elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp)
    )
}

@Preview(backgroundColor = 0xFFFFFF)
@Composable
fun PreviewSoptampFloatingButton() {
    SoptampTheme {
        Scaffold(
            floatingActionButton = {
                SoptampFloatingButton(text = "test")
            }
        ) { paddingValues -> paddingValues }
    }
}
