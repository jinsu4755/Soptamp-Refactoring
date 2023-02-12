package org.sopt.android.local.source

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.lastOrNull
import org.sopt.android.data.error.ErrorData
import org.sopt.android.data.source.UserDataSource
import org.sopt.android.local.datastore.SoptampDataStore
import javax.inject.Inject

internal class LocalUserDataSource @Inject constructor(
    private val dataStore: SoptampDataStore
) : UserDataSource {
    override suspend fun setUserId(userId: Long) {
        dataStore.setUserId(userId)
    }

    override suspend fun getUserId(): Result<Long> {
        val userId: Result<Long> = kotlin.runCatching {
            dataStore.userId.last()
        }
        return when (userId.exceptionOrNull()) {
            null -> userId
            else -> Result.failure(ErrorData.NotUsefulCredentials(NOT_USEFUL_CREDENTIALS))
        }
    }

    override suspend fun setUserMessage(message: String?) {
        dataStore.setProfileMessage(message)
    }

    override suspend fun getUserMessage(): Result<String> = kotlin.runCatching {
        dataStore.profileMessage
            .lastOrNull()
            ?: SoptampDataStore.NULL_PROFILE_MESSAGE
    }

    companion object {
        const val NOT_USEFUL_CREDENTIALS = "인증정보가 유효하지 않습니다."
    }
}
