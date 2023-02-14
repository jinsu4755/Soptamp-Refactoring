package org.sopt.android.data.mapper

import org.sopt.android.data.model.MissionData
import org.sopt.android.domain.model.Mission

fun List<MissionData>.toDomain() = this.map {
    it.toDomain()
}

fun MissionData.toDomain() = Mission(
    id,
    title,
    level,
    profileImage,
    isCompleted
)
