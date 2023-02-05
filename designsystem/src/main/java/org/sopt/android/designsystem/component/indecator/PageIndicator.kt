package org.sopt.android.designsystem.component.indecator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(
    numberOfPages: Int,
    modifier: Modifier = Modifier,
    selectedPage: Int = 0,
    selectedColor: Color = Color.Blue,
    defaultColor: Color = Color.LightGray,
    defaultRadius: Dp = 20.dp,
    selectedLength: Dp = 60.dp,
    space: Dp = 30.dp,
    animationDurationInMillis: Int = 200
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space),
        modifier = modifier
    ) {
        (0 until numberOfPages).forEach { page ->
            PageIndicatorView(
                isSelected = page == selectedPage,
                selectedColor = selectedColor,
                defaultColor = defaultColor,
                defaultRadius = defaultRadius,
                selectedLength = selectedLength,
                animationDurationInMillis = animationDurationInMillis
            )
        }
    }
}
