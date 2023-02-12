package org.sopt.android.data.mapper

import org.sopt.android.data.model.LoginData
import org.sopt.android.domain.model.Login

fun LoginData.toDomain() = Login(
    this.userId,
    this.profileMessage
)
