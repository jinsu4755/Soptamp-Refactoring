package org.sopt.android.designsystem.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import org.sopt.android.designsystem.style.SoptampTheme

@Composable
fun SoptampButton(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle,
    textColor: Color,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = SoptampTheme.colors.purple300
    ),
    contentPadding: PaddingValues = PaddingValues(vertical = SoptampTheme.dimens.defaultButtonVerticalPadding),
    shape: Shape = RoundedCornerShape(9.dp),
    elevation: ButtonElevation = ButtonDefaults.elevation(0.dp, 0.dp),
    onClick: () -> Unit = {},
    isEnable: Boolean = true
) {
    Button(
        modifier = modifier,
        contentPadding = contentPadding,
        onClick = { onClick() },
        shape = shape,
        colors = buttonColors,
        elevation = elevation,
        enabled = isEnable
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor
        )
    }
}
