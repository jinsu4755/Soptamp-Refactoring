package org.sopt.android.presentation.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.sopt.android.designsystem.component.indecator.PageIndicator
import org.sopt.android.designsystem.style.SoptampTheme
import org.sopt.android.presentation.config.OnboardingNavGraph
import org.sopt.android.presentation.onboarding.component.OnboardingPage
import org.sopt.android.presentation.onboarding.model.OnBoardingPageUiModel

@OnboardingNavGraph(true)
@Destination("onboarding step")
@Composable
fun OnboardingScreen(
    navigator: DestinationsNavigator
) {
    SoptampTheme {
        OnboardingScreen(
            onClickStart = { navigator }
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(
    onClickStart: () -> Unit = {}
) {
    val pageState = rememberPagerState()
    val onboardingPages = OnBoardingPageUiModel.values()
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 69.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            count = onboardingPages.size,
            state = pageState,
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            OnboardingPage(
                image = onboardingPages[pageState.currentPage].image,
                title = onboardingPages[pageState.currentPage].title,
                content = onboardingPages[pageState.currentPage].content
            )
        }
        Spacer(modifier = Modifier.size(28.dp))
        PageIndicator(
            numberOfPages = onboardingPages.size,
            selectedPage = pageState.currentPage,
            defaultRadius = 4.dp,
            defaultColor = SoptampTheme.colors.purple300,
            selectedColor = SoptampTheme.colors.purple200,
            selectedLength = 20.dp,
            space = 10.dp,
            animationDurationInMillis = 100
        )
        Spacer(modifier = Modifier.size(52.dp))
        OnboardingButton(
            isButtonEnabled = (pageState.currentPage + 1 == onboardingPages.size),
            onClick = { onClickStart() }
        )
    }
}

@Composable
fun OnboardingButton(
    isButtonEnabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(
                horizontal = SoptampTheme.dimens.defaultHorizontalPadding
            )
    ) {
        Button(
            onClick = { onClick() },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(9.dp),
            contentPadding = PaddingValues(vertical = 17.dp),
            enabled = isButtonEnabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = SoptampTheme.colors.purple300,
                disabledBackgroundColor = SoptampTheme.colors.purple200
            ),
            elevation = ButtonDefaults.elevation(0.dp, 0.dp)
        ) {
            Text(
                text = "시작하기",
                style = SoptampTheme.typography.h2,
                color = SoptampTheme.colors.white
            )
        }
    }
}

@Preview(backgroundColor = 0xFFFFFF)
@Composable
fun PreviewOnboardingScreen() {
    SoptampTheme {
        OnboardingScreen()
    }
}
