package org.sopt.android.designsystem.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import org.sopt.android.designsystem.component.utils.noRippleClickable

@Composable
fun UnderLineTextButton(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    color: Color,
    textAlign: TextAlign = TextAlign.Start,
    paddingValue: PaddingValues = PaddingValues(),
    onClick: () -> Unit = {}

) {
    Text(
        text = text,
        style = style,
        color = color,
        textDecoration = TextDecoration.Underline,
        textAlign = textAlign,
        modifier = modifier.padding(
            paddingValue
        ).noRippleClickable {
            onClick()
        }
    )
}
