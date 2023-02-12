package org.sopt.android.data.source

interface UserDataSource {
    suspend fun setUserId(userId: Long)
    suspend fun getUserId(): Result<Long>
    suspend fun setUserMessage(message: String?)
    suspend fun getUserMessage(): Result<String>
}
