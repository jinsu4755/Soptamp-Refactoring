package org.sopt.android.designsystem.component.mission

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import org.sopt.android.designsystem.component.mission.model.Stamp

@Composable
fun CompletedStamp(
    stamp: Stamp,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = stamp.lottieImage),
        contentDescription = "Completed Stamp Image",
        modifier = modifier
    )
}
