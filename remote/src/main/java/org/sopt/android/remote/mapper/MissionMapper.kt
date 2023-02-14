package org.sopt.android.remote.mapper

import org.sopt.android.data.model.MissionData
import org.sopt.android.remote.model.response.MissionResponse

fun List<MissionResponse>.toData() = this.map { it.toData() }

fun MissionResponse.toData() = MissionData(
    this.id,
    this.title,
    this.level,
    this.profileImage,
    this.isCompleted
)
