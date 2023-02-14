package org.sopt.android.presentation.mission.model

import org.sopt.android.domain.model.Mission

data class MissionUiModel(
    val id: Int,
    val title: String,
    val level: Int,
    val isCompleted: Boolean
)

fun Mission.toUiModel(): MissionUiModel = MissionUiModel(
    id = this.id,
    title = this.title,
    level = this.level,
    isCompleted = this.isCompleted
)
