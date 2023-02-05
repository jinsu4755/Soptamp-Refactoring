package org.sopt.android.presentation.onboarding.model

import androidx.annotation.DrawableRes
import org.sopt.android.designsystem.R

enum class OnBoardingPageUiModel(
    @DrawableRes val image: Int,
    val title: String,
    val content: String
) {
    FIRST(
        image = R.drawable.andriod_img1,
        title = "A부터 Z까지 SOPT 즐기기",
        content = "동아리 활동을 더욱 재미있게\n즐기는 방법을 알려드려요!"
    ),
    SECOND(
        image = R.drawable.andriod_img2,
        title = "랭킹으로 다같이 참여하기",
        content = "미션을 달성하고 랭킹이 올라가는\n재미를 느껴보세요!"
    ),
    THIRD(
        image = R.drawable.andriod_img3,
        title = "완료된 미션으로 추억 감상하기",
        content = "완료된 미션을 확인하며\n추억을 감상할 수 있어요"
    );
}
