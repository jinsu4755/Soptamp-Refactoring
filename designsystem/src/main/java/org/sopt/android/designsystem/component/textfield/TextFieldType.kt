package org.sopt.android.designsystem.component.textfield

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.sopt.android.designsystem.style.SoptampTheme

enum class TextFieldType {
    GRAY,
    WHITE,
    ERROR;

    val backgroundColor: Color
        @Composable get() = when (this) {
            GRAY -> SoptampTheme.colors.onSurface5
            WHITE -> SoptampTheme.colors.white
            ERROR -> SoptampTheme.colors.error100
        }

    val borderColor: Color
        @Composable get() = when (this) {
            GRAY -> SoptampTheme.colors.onSurface5
            WHITE -> SoptampTheme.colors.purple300
            ERROR -> SoptampTheme.colors.error200
        }
}
