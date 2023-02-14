package org.sopt.android.designsystem.component.mission

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import org.sopt.android.designsystem.R
import org.sopt.android.designsystem.component.mission.model.Stamp

@Composable
fun LevelOfMission(stamp: Stamp, spaceSize: Dp) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(spaceSize)
    ) {
        MissionLevelOfStar(stamp = stamp)
    }
}

@Composable
private fun MissionLevelOfStar(stamp: Stamp) {
    (Stamp.getMin()..Stamp.getMax()).forEach {
        val starColor = if (it <= stamp.missionLevel) {
            stamp.starColor
        } else {
            Stamp.defaultStarColor
        }
        Icon(
            painter = painterResource(id = R.drawable.level_star),
            contentDescription = "Star Of Mission Level",
            tint = starColor
        )
    }
}
