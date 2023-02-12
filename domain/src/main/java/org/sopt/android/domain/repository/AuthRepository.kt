package org.sopt.android.domain.repository

import org.sopt.android.domain.model.Login
import org.sopt.android.domain.model.Register

interface AuthRepository {
    suspend fun checkNickname(nickname: String): Result<Unit>
    suspend fun checkEmail(email: String): Result<Unit>
    suspend fun register(nickname: String, email: String, password: String): Result<Register>
    suspend fun login(email: String, password: String): Result<Login>
}
