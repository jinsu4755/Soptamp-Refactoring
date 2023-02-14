package org.sopt.android.domain.model

data class Mission(
    val id: Int,
    val title: String,
    val level: Int,
    val profileImage: List<String>?,
    val isCompleted: Boolean
)
