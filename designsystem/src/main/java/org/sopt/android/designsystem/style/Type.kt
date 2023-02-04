package org.sopt.android.designsystem.style

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.sopt.android.designsystem.R

val PretendardBold = FontFamily(Font(R.font.pretendard_bold, FontWeight.Bold))
val PretendardMedium = FontFamily(Font(R.font.pretendard_medium, FontWeight.Medium))
val PretendardRegular = FontFamily(Font(R.font.pretendard_regular, FontWeight.Normal))
val MontserratBold = FontFamily(Font(R.font.montserrat_bold, FontWeight.Bold))
val MontserratRegular = FontFamily(Font(R.font.montserrat_regular, FontWeight.Normal))

fun typography(): SoptampTypography = SoptampTypography(
    h1 = TextStyle(
        fontFamily = PretendardBold,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    ),
    h2 = TextStyle(
        fontFamily = PretendardBold,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    h3 = TextStyle(
        fontFamily = PretendardBold,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    ),
    h4 = TextStyle(
        fontFamily = MontserratBold,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    ),
    sub1 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    sub2 = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    sub3 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    ),
    sub4 = TextStyle(
        fontFamily = MontserratRegular,
        fontSize = 30.sp,
        fontWeight = FontWeight.Normal
    ),
    caption1 = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    caption2 = TextStyle(
        fontFamily = PretendardMedium,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium
    ),
    caption3 = TextStyle(
        fontFamily = PretendardRegular,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    ),
    caption4 = TextStyle(
        fontFamily = MontserratRegular,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    )
)
