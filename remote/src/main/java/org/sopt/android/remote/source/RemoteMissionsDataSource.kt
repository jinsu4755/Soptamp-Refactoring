package org.sopt.android.remote.source

import org.sopt.android.data.source.MissionsDataSource
import org.sopt.android.remote.api.MissionsService
import javax.inject.Inject

internal class RemoteMissionsDataSource @Inject constructor(
    private val service: MissionsService
) : MissionsDataSource {
    suspend fun getAllMissions(userId: Long) {
        val missions = kotlin.runCatching {
            service.getAllMissions(userId)
        }
    }
}
