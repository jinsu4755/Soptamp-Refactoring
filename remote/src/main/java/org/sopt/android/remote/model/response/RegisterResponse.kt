package org.sopt.android.remote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponse(
    val userId: Long
)
