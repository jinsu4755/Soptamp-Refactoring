package org.sopt.android.remote.model.request

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    val nickname: String,
    val email: String,
    val password: String
)
