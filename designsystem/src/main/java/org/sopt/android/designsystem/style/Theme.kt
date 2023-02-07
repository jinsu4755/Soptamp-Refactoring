package org.sopt.android.designsystem.style

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.rememberSystemUiController

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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SoptampTheme(
    darkTheme: Boolean = false,
    colors: SoptampColorScheme = SoptampTheme.colors,
    typography: SoptampTypography = SoptampTheme.typography,
    dimens: SoptampDimensions = SoptampTheme.dimens,
    content: @Composable () -> Unit
) {
    val colorScheme = remember {
        colors.copy()
    }.apply { updateColorsFrom(colors) }

    val systemUiController = rememberSystemUiController()
    val systemUiColor = if (darkTheme) {
        colorScheme.black
    } else {
        colorScheme.white
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            systemUiController.setStatusBarColor(systemUiColor, !darkTheme)
            systemUiController.setSystemBarsColor(systemUiColor, !darkTheme)
            view.setBackgroundColor(systemUiColor.toArgb())
        }
    }
    CompositionLocalProvider(
        LocalColors provides colorScheme,
        LocalTypography provides typography,
        LocalDimensions provides dimens,
        LocalOverscrollConfiguration provides null
    ) {
        Surface(
            modifier = Modifier.windowInsetsPadding(
                WindowInsets.systemBars.only(
                    WindowInsetsSides.Vertical
                )
            )
        ) {
            content()
        }
    }
}
