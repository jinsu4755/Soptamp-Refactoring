package org.sopt.android.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.android.designsystem.style.SoptampTheme

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.fillMaxWidth(0.2f),
            color = SoptampTheme.colors.purple300,
            strokeWidth = 3.dp
        )
    }
}

@Preview
@Composable
fun PreviewLoadingScreen() {
    SoptampTheme {
        LoadingScreen()
    }
}
