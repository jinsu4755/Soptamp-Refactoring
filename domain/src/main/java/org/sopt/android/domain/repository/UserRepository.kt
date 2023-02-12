package org.sopt.android.domain.repository

interface UserRepository {
    suspend fun setUserMessage(message: String?)
    suspend fun getUserMessage(): Result<String>
}
