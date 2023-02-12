package org.sopt.android.data.repository

import org.sopt.android.data.error.ErrorData
import org.sopt.android.data.mapper.toDomain
import org.sopt.android.data.source.UserDataSource
import org.sopt.android.domain.repository.UserRepository
import javax.inject.Inject

internal class LocalUserRepository @Inject constructor(
    private val userDataSource: UserDataSource
) : UserRepository {
    suspend fun setUserId(userId: Long) {
        userDataSource.setUserId(userId)
    }

    suspend fun getUserId(): Result<Long> {
        val userId: Result<Long> = userDataSource.getUserId()
        val exception = userId.exceptionOrNull()
        return if (exception is ErrorData) {
            Result.failure(exception.toDomain())
        } else {
            userId
        }
    }

    override suspend fun setUserMessage(message: String?) {
        userDataSource.setUserMessage(message)
    }

    override suspend fun getUserMessage() = userDataSource.getUserMessage()
}
