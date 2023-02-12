package org.sopt.android.remote.source

import org.sopt.android.data.model.LoginData
import org.sopt.android.data.model.RegisterData
import org.sopt.android.data.source.AuthDataSource
import org.sopt.android.remote.api.AuthService
import org.sopt.android.remote.mapper.toData
import org.sopt.android.remote.model.request.LoginRequest
import org.sopt.android.remote.model.request.RegisterRequest
import org.sopt.android.remote.utils.classifyResult
import javax.inject.Inject

internal class RemoteAuthDataSource @Inject constructor(
    private val authService: AuthService
) : AuthDataSource {

    override suspend fun checkNickname(
        nickname: String
    ): Result<Unit> {
        val response: Result<Unit> = kotlin.runCatching {
            authService.checkNickname(nickname)
        }
        return classifyResult(response)
    }

    override suspend fun checkEmail(
        email: String
    ): Result<Unit> {
        val response: Result<Unit> = kotlin.runCatching {
            authService.checkEmail(email)
        }
        return classifyResult(response)
    }

    override suspend fun register(
        nickname: String,
        email: String,
        password: String
    ): Result<RegisterData> {
        val request = RegisterRequest(nickname, email, password)
        val response: Result<RegisterData> = kotlin.runCatching {
            authService.register(request).toData()
        }
        return classifyResult(response)
    }

    override suspend fun login(
        email: String,
        password: String
    ): Result<LoginData> {
        val request = LoginRequest(email, password)
        val response: Result<LoginData> = kotlin.runCatching {
            authService.login(request).toData()
        }
        return classifyResult(response)
    }
}
