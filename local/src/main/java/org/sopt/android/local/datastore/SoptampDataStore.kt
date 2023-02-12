package org.sopt.android.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(name = "pref")

internal class SoptampDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {
    val userId: Flow<Long> = context.dataStore.data.map { preferences -> preferences[USER_ID] ?: -1 }
    val profileMessage: Flow<String?> = context.dataStore.data.map { preferences -> preferences[PROFILE_MESSAGE] ?: "" }

    suspend fun setUserId(userId: Long) {
        context.dataStore.edit { pref ->
            pref[USER_ID] = userId
        }
    }

    suspend fun setProfileMessage(message: String?) {
        context.dataStore.edit { preferences ->
            preferences[PROFILE_MESSAGE] = message ?: NULL_PROFILE_MESSAGE
        }
    }

    companion object {
        private val USER_ID = longPreferencesKey("user")
        private val PROFILE_MESSAGE = stringPreferencesKey("profile_message")
        const val NULL_PROFILE_MESSAGE = "설정된 한 마디가 없습니다"
    }
}
