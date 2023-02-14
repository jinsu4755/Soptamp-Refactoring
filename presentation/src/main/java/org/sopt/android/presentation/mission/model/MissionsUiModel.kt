package org.sopt.android.presentation.mission.model

import org.sopt.android.domain.model.Mission

data class MissionsUiModel(
    val title: String,
    val contents: List<MissionUiModel>
)

fun List<Mission>.toUiModel(title: String): MissionsUiModel = MissionsUiModel(
    title = title,
    contents = this
        .filter { it.level <= 3 }
        .map { it.toUiModel() }
)
