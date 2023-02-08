package org.sopt.android.remote.mapper

import org.sopt.android.data.model.RegisterData
import org.sopt.android.remote.model.response.RegisterResponse

fun RegisterResponse.toData() = RegisterData(
    userId = this.userId
)
