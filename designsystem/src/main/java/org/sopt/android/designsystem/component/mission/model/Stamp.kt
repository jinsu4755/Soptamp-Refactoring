package org.sopt.android.designsystem.component.mission.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.sopt.android.designsystem.R
import org.sopt.android.designsystem.style.SoptampTheme

enum class Stamp(
    val missionLevel: Int,
    @DrawableRes val lottieImage: Int
) {
    LEVEL1(1, R.drawable.pinkstamp_image),
    LEVEL2(2, R.drawable.purplestamp_image),
    LEVEL3(3, R.drawable.greenstamp_image);

    val starColor: Color
        @Composable get() = when (this) {
            LEVEL1 -> SoptampTheme.colors.pink300
            LEVEL2 -> SoptampTheme.colors.purple300
            LEVEL3 -> SoptampTheme.colors.mint300
        }

    val background: Color
        @Composable get() = when (this) {
            LEVEL1 -> SoptampTheme.colors.pink100
            LEVEL2 -> SoptampTheme.colors.purple100
            LEVEL3 -> SoptampTheme.colors.mint100
        }

    fun hasStampLevel(level: Int): Boolean {
        return this.missionLevel == level
    }

    companion object {
        val defaultStarColor: Color
            @Composable get() = SoptampTheme.colors.onSurface30

        fun getMin() = values().minOfOrNull { it.missionLevel } ?: 1
        fun getMax() = values().maxOfOrNull { it.missionLevel } ?: 3

        fun findStampByLevel(level: Int): Stamp = values().find {
            it.hasStampLevel(level)
        } ?: throw IllegalArgumentException("$level 에 해당하는 Stamp 가 없습니다.")
    }
}
