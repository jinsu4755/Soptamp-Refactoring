package org.sopt.android.designsystem.style

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class SoptampDimensions(
    val defaultHorizontalPadding: Dp = 16.dp
)

internal val LocalDimensions = staticCompositionLocalOf { SoptampDimensions() }
