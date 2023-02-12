package org.sopt.android.data.source

import org.sopt.android.data.model.LoginData
import org.sopt.android.data.model.RegisterData

interface AuthDataSource {
    suspend fun checkNickname(nickname: String): Result<Unit>
    suspend fun checkEmail(email: String): Result<Unit>
    suspend fun register(nickname: String, email: String, password: String): Result<RegisterData>
    suspend fun login(email: String, password: String): Result<LoginData>
}
