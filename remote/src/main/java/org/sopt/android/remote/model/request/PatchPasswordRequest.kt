package org.sopt.android.remote.model.request

import kotlinx.serialization.Serializable

@Serializable
data class PatchPasswordRequest(
    val password: String
)
