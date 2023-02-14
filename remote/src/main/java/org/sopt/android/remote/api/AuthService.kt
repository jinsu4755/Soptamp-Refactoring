package org.sopt.android.remote.api

import org.sopt.android.remote.model.request.LoginRequest
import org.sopt.android.remote.model.request.PatchNicknameRequest
import org.sopt.android.remote.model.request.PatchPasswordRequest
import org.sopt.android.remote.model.request.RegisterRequest
import org.sopt.android.remote.model.response.LoginResponse
import org.sopt.android.remote.model.response.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Query

internal interface AuthService {
    @POST("user/signup")
    suspend fun register(
        @Body request: RegisterRequest
    ): RegisterResponse

    @GET("auth?nickname={nickname}")
    suspend fun checkNickname(
        @Query("nickname") nickname: String
    ): Unit

    @GET("auth?email={email}")
    suspend fun checkEmail(
        @Query("email") email: String
    ): Unit

    @POST("user/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

    @PATCH("auth/password")
    suspend fun patchPassword(
        @Header("userId") userId: Long,
        @Body request: PatchPasswordRequest
    ): Unit

    @PATCH("auth/nickname")
    suspend fun patchNickname(
        @Header("userId") userId: Long,
        @Body request: PatchNicknameRequest
    ): Unit

    @DELETE("auth/withdraw")
    suspend fun withdraw(
        @Header("userId") userId: Long
    ): Unit
}
