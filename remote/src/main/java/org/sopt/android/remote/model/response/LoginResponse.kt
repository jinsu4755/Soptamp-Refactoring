package org.sopt.android.remote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val userId: Long,
    val profileMessage: String?
)
