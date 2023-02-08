package org.sopt.android.remote.api

import org.sopt.android.remote.model.request.LoginRequest
import org.sopt.android.remote.model.request.PatchNicknameRequest
import org.sopt.android.remote.model.request.PatchPasswordRequest
import org.sopt.android.remote.model.request.RegisterRequest
import org.sopt.android.remote.model.response.LoginResponse
import org.sopt.android.remote.model.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {
    @POST("user/signup")
    suspend fun register(
        @Body request: RegisterRequest
    ): Response<RegisterResponse>

    @GET("auth?nickname={nickname}")
    suspend fun checkNickname(
        @Query("nickname") nickname: String
    ): Response<Unit>

    @GET("auth?email={email}")
    suspend fun checkEmail(
        @Query("email") email: String
    ): Response<Unit>

    @POST("user/login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @PATCH("auth/password")
    suspend fun patchPassword(
        @Header("userId") userId: Long,
        @Body request: PatchPasswordRequest
    ): Response<Unit>

    @PATCH("auth/nickname")
    suspend fun patchNickname(
        @Header("userId") userId: Long,
        @Body request: PatchNicknameRequest
    ): Response<Unit>

    @DELETE("auth/withdraw")
    suspend fun withdraw(
        @Header("userId") userId: Long
    ): Response<Unit>
}
