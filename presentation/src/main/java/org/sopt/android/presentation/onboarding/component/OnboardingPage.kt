package org.sopt.android.presentation.onboarding.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.android.designsystem.style.SoptampTheme

@Composable
fun OnboardingPage(
    @DrawableRes image: Int,
    title: String,
    content: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.fillMaxWidth()
                .aspectRatio(1f),
            painter = painterResource(id = image),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(16.dp))
        OnboardingPageTitle(text = title)
        Spacer(modifier = Modifier.size(12.dp))
        OnboardingPageContent(text = content)
    }
}

@Composable
fun OnboardingPageTitle(text: String) {
    Text(
        text = text,
        style = SoptampTheme.typography.h1,
        color = SoptampTheme.colors.onSurface90
    )
}

@Composable
fun OnboardingPageContent(text: String) {
    Text(
        text = text,
        style = SoptampTheme.typography.sub2,
        color = SoptampTheme.colors.onSurface50
    )
}
