package org.sopt.android.designsystem.style

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

internal val LocalColors = staticCompositionLocalOf {
    lightColorScheme()
}

internal val LocalTypography = staticCompositionLocalOf {
    typography()
}

object SoptampTheme {
    val colors: SoptampColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: SoptampTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val dimens: SoptampDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current
}

@Composable
fun SoptampTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: SoptampColorScheme = SoptampTheme.colors,
    typography: SoptampTypography = SoptampTheme.typography,
    dimens: SoptampDimensions = SoptampTheme.dimens,
    content: @Composable () -> Unit
) {
    val rememberColorScheme = remember {
        colors.copy()
    }.apply { updateColorsFrom(colors) }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = if (darkTheme) {
                rememberColorScheme.black.toArgb()
            } else {
                rememberColorScheme.white.toArgb()
            }
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }
    CompositionLocalProvider(
        LocalColors provides rememberColorScheme,
        LocalTypography provides typography,
        LocalDimensions provides dimens
    ) {
        content()
    }
}
