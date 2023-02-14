package org.sopt.android.designsystem.component.mission

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.android.designsystem.component.mission.model.Stamp
import org.sopt.android.designsystem.component.mission.shape.MissionShape
import org.sopt.android.designsystem.component.utils.noRippleClickable
import org.sopt.android.designsystem.style.SoptampTheme

@Composable
fun MissionComponent(
    id: Int = 0,
    title: String = "",
    level: Int = 0,
    isCompleted: Boolean = false,
    onClick: (() -> Unit) = {}
) {
    val shape = MissionShape.DEFAULT_WAVE
    val stamp = Stamp.findStampByLevel(level)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(160.dp, 200.dp)
            .aspectRatio(0.8f)
            .background(
                color = if (isCompleted) stamp.background else SoptampTheme.colors.onSurface5,
                shape = shape
            )
            .noRippleClickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isCompleted) {
            CompletedStamp(
                stamp = stamp,
                modifier = Modifier.aspectRatio(1.3f)
                    .padding(horizontal = 12.dp)
            )
        } else {
            LevelOfMission(stamp = stamp, spaceSize = 10.dp)
        }
        Spacer(modifier = Modifier.size((if (isCompleted) 8 else 16).dp))
        TitleOfMission(missionTitle = title)
    }
}

@Composable
private fun TitleOfMission(missionTitle: String) {
    val missionText = if (missionTitle.length > 11) {
        StringBuilder(missionTitle).insert(11, "\n")
            .toString()
    } else {
        missionTitle
    }
    Text(
        text = missionText,
        style = SoptampTheme.typography.sub3,
        textAlign = TextAlign.Center,
        maxLines = 2,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp)
    )
}

@Preview(showBackground = true, backgroundColor = 0xff000000)
@Composable
fun PreviewMissionComponent() {
    SoptampTheme {
        MissionComponent(
            title = "일이삼사오육칠팔구십일일이삼사오육칠팔구십일",
            level = 1,
            isCompleted = !false
        )
    }
}
