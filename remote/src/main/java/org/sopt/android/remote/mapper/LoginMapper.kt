package org.sopt.android.remote.mapper

import org.sopt.android.data.model.LoginData
import org.sopt.android.remote.model.response.LoginResponse

fun LoginResponse.toData() = LoginData(
    userId = this.userId,
    profileMessage = this.profileMessage
)
