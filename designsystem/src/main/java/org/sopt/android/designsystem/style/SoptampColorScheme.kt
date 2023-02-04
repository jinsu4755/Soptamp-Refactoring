package org.sopt.android.designsystem.style

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Stable
class SoptampColorScheme(
    purple300: Color,
    purple200: Color,
    purple100: Color,
    pink300: Color,
    pink200: Color,
    pink100: Color,
    mint300: Color,
    mint200: Color,
    mint100: Color,
    error300: Color,
    error200: Color,
    error100: Color,
    access300: Color,
    onSurface: Color,
    onSurface90: Color,
    onSurface80: Color,
    onSurface70: Color,
    onSurface60: Color,
    onSurface50: Color,
    onSurface40: Color,
    onSurface30: Color,
    onSurface20: Color,
    onSurface10: Color,
    onSurface5: Color,
    white: Color,
    black: Color
) {
    var purple300 by mutableStateOf(purple300)
        private set
    var purple200 by mutableStateOf(purple200)
        private set
    var purple100 by mutableStateOf(purple100)
        private set
    var pink300 by mutableStateOf(pink300)
        private set
    var pink200 by mutableStateOf(pink200)
        private set
    var pink100 by mutableStateOf(pink100)
        private set
    var mint300 by mutableStateOf(mint300)
        private set
    var mint200 by mutableStateOf(mint200)
        private set
    var mint100 by mutableStateOf(mint100)
        private set
    var error300 by mutableStateOf(error300)
        private set
    var error200 by mutableStateOf(error200)
        private set
    var error100 by mutableStateOf(error100)
        private set
    var access300 by mutableStateOf(access300)
        private set
    var onSurface by mutableStateOf(onSurface)
        private set
    var onSurface90 by mutableStateOf(onSurface90)
        private set
    var onSurface80 by mutableStateOf(onSurface80)
        private set
    var onSurface70 by mutableStateOf(onSurface70)
        private set
    var onSurface60 by mutableStateOf(onSurface60)
        private set
    var onSurface50 by mutableStateOf(onSurface50)
        private set
    var onSurface40 by mutableStateOf(onSurface40)
        private set
    var onSurface30 by mutableStateOf(onSurface30)
        private set
    var onSurface20 by mutableStateOf(onSurface20)
        private set
    var onSurface10 by mutableStateOf(onSurface10)
        private set
    var onSurface5 by mutableStateOf(onSurface5)
        private set
    var white by mutableStateOf(white)
        private set
    var black by mutableStateOf(black)
        private set

    fun copy(): SoptampColorScheme = SoptampColorScheme(
        purple300 = purple300,
        purple200 = purple200,
        purple100 = purple100,
        pink300 = pink300,
        pink200 = pink200,
        pink100 = pink100,
        mint300 = mint300,
        mint200 = mint200,
        mint100 = mint100,
        error300 = error300,
        error200 = error200,
        error100 = error100,
        access300 = access300,
        onSurface = onSurface,
        onSurface90 = onSurface90,
        onSurface80 = onSurface80,
        onSurface70 = onSurface70,
        onSurface60 = onSurface60,
        onSurface50 = onSurface50,
        onSurface40 = onSurface40,
        onSurface30 = onSurface30,
        onSurface20 = onSurface20,
        onSurface10 = onSurface10,
        onSurface5 = onSurface5,
        white = white,
        black = black
    )

    fun updateColorsFrom(other: SoptampColorScheme) {
        purple300 = other.purple300
        purple200 = other.purple200
        purple100 = other.purple100
        pink300 = other.pink300
        pink200 = other.pink200
        pink100 = other.pink100
        mint300 = other.mint300
        mint200 = other.mint200
        mint100 = other.mint100
        error300 = other.error300
        error200 = other.error200
        error100 = other.error100
        access300 = other.access300
        onSurface = other.onSurface
        onSurface90 = other.onSurface90
        onSurface80 = other.onSurface80
        onSurface70 = other.onSurface70
        onSurface60 = other.onSurface60
        onSurface50 = other.onSurface50
        onSurface40 = other.onSurface40
        onSurface30 = other.onSurface30
        onSurface20 = other.onSurface20
        onSurface10 = other.onSurface10
        onSurface5 = other.onSurface5
        white = other.white
        black = other.black
    }

    override fun toString(): String {
        return "SoptampColorScheme(" +
            "purple300=$purple300, " +
            "purple200=$purple200, " +
            "purple100=$purple100, " +
            "pink300=$pink300, " +
            "pink200=$pink200, " +
            "pink100=$pink100, " +
            "mint300=$mint300, " +
            "mint200=$mint200, " +
            "mint100=$mint100, " +
            "error300=$error300, " +
            "error200=$error200, " +
            "error100=$error100, " +
            "access300=$access300, " +
            "onSurface=$onSurface, " +
            "onSurface90=$onSurface90, " +
            "onSurface80=$onSurface80, " +
            "onSurface70=$onSurface70, " +
            "onSurface60=$onSurface60, " +
            "onSurface50=$onSurface50, " +
            "onSurface40=$onSurface40, " +
            "onSurface30=$onSurface30, " +
            "onSurface20=$onSurface20, " +
            "onSurface10=$onSurface10, " +
            "onSurface5=$onSurface5, " +
            "white=$white, " +
            "black=$black)"
    }
}
