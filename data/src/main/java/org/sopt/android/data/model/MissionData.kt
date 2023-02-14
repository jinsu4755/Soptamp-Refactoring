package org.sopt.android.data.model

data class MissionData(
    val id: Int,
    val title: String,
    val level: Int,
    val profileImage: List<String>?,
    val isCompleted: Boolean
)
