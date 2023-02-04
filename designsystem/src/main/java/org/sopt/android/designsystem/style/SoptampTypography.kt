package org.sopt.android.designsystem.style

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
class SoptampTypography internal constructor(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val sub1: TextStyle,
    val sub2: TextStyle,
    val sub3: TextStyle,
    val sub4: TextStyle,
    val caption1: TextStyle,
    val caption2: TextStyle,
    val caption3: TextStyle,
    val caption4: TextStyle
) {
    fun copy(
        h1: TextStyle = this.h1,
        h2: TextStyle = this.h2,
        h3: TextStyle = this.h3,
        h4: TextStyle = this.h4,
        sub1: TextStyle = this.sub1,
        sub2: TextStyle = this.sub2,
        sub3: TextStyle = this.sub3,
        sub4: TextStyle = this.sub4,
        caption1: TextStyle = this.caption1,
        caption2: TextStyle = this.caption2,
        caption3: TextStyle = this.caption3,
        caption4: TextStyle = this.caption4
    ): SoptampTypography = SoptampTypography(
        h1 = h1,
        h2 = h2,
        h3 = h3,
        h4 = h4,
        sub1 = sub1,
        sub2 = sub2,
        sub3 = sub3,
        sub4 = sub4,
        caption1 = caption1,
        caption2 = caption2,
        caption3 = caption3,
        caption4 = caption4
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SoptampTypography

        if (h1 != other.h1) return false
        if (h2 != other.h2) return false
        if (h3 != other.h3) return false
        if (h4 != other.h4) return false
        if (sub1 != other.sub1) return false
        if (sub2 != other.sub2) return false
        if (sub3 != other.sub3) return false
        if (sub4 != other.sub4) return false
        if (caption1 != other.caption1) return false
        if (caption2 != other.caption2) return false
        if (caption3 != other.caption3) return false
        if (caption4 != other.caption4) return false

        return true
    }

    override fun hashCode(): Int {
        var result = h1.hashCode()
        result = 31 * result + h2.hashCode()
        result = 31 * result + h3.hashCode()
        result = 31 * result + h4.hashCode()
        result = 31 * result + sub1.hashCode()
        result = 31 * result + sub2.hashCode()
        result = 31 * result + sub3.hashCode()
        result = 31 * result + sub4.hashCode()
        result = 31 * result + caption1.hashCode()
        result = 31 * result + caption2.hashCode()
        result = 31 * result + caption3.hashCode()
        result = 31 * result + caption4.hashCode()
        return result
    }

    override fun toString(): String {
        return "SoptampTypography(" +
            "h1=$h1, " +
            "h2=$h2, " +
            "h3=$h3, " +
            "h4=$h4, " +
            "sub1=$sub1, " +
            "sub2=$sub2, " +
            "sub3=$sub3, " +
            "sub4=$sub4, " +
            "caption1=$caption1, " +
            "caption2=$caption2, " +
            "caption3=$caption3, " +
            "caption4=$caption4" +
            ")"
    }
}
