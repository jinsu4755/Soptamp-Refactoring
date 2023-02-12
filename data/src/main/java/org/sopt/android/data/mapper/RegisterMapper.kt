package org.sopt.android.data.mapper

import org.sopt.android.data.model.RegisterData
import org.sopt.android.domain.model.Register

fun RegisterData.toDomain() = Register(
    this.userId
)
