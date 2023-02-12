package org.sopt.android.data.repository

import org.sopt.android.data.ErrorData
import org.sopt.android.data.mapper.toDomain
import org.sopt.android.data.source.AuthDataSource
import org.sopt.android.domain.model.Login
import org.sopt.android.domain.model.Register
import org.sopt.android.domain.repository.AuthRepository
import javax.inject.Inject

internal class RemoteAuthRepository @Inject constructor(
    private val authDataSource: AuthDataSource
) : AuthRepository {
    override suspend fun checkNickname(
        nickname: String
    ): Result<Unit> {
        val checkedNickname: Result<Unit> = authDataSource.checkNickname(nickname)

        val exception = checkedNickname.exceptionOrNull()
        return if (exception is ErrorData) {
            Result.failure(exception.toDomain())
        } else {
            checkedNickname
        }
    }

    override suspend fun checkEmail(
        email: String
    ): Result<Unit> {
        val checkedEmail: Result<Unit> = authDataSource.checkEmail(email)

        val exception = checkedEmail.exceptionOrNull()
        return if (exception is ErrorData) {
            Result.failure(exception.toDomain())
        } else {
            checkedEmail
        }
    }

    override suspend fun register(
        nickname: String,
        email: String,
        password: String
    ): Result<Register> {
        val register: Result<Register> = authDataSource
            .register(nickname, email, password)
            .mapCatching { it.toDomain() }
        val exception = register.exceptionOrNull()
        return if (exception is ErrorData) {
            Result.failure(exception.toDomain())
        } else {
            register
        }
    }

    override suspend fun login(
        email: String,
        password: String
    ): Result<Login> {
        val login: Result<Login> = authDataSource
            .login(email, password)
            .mapCatching { it.toDomain() }
        val exception = login.exceptionOrNull()
        return if (exception is ErrorData) {
            Result.failure(exception.toDomain())
        } else {
            login
        }
    }
}
