package org.sopt.android.remote.source

import org.sopt.android.data.model.MissionData
import org.sopt.android.data.source.MissionsDataSource
import org.sopt.android.remote.api.MissionsService
import org.sopt.android.remote.mapper.toData
import org.sopt.android.remote.utils.classifyResult
import javax.inject.Inject

internal class RemoteMissionsDataSource @Inject constructor(
    private val service: MissionsService
) : MissionsDataSource {
    override suspend fun getAllMissions(userId: Long): Result<List<MissionData>> {
        val missions = kotlin.runCatching {
            service.getAllMissions(userId).toData()
        }
        return classifyResult(missions)
    }

    override suspend fun getCompleteMissions(userId: Long): Result<List<MissionData>> {
        val missions = kotlin.runCatching {
            service.getAllMissions(userId).filter { it.isCompleted }.toData()
        }
        return classifyResult(missions)
    }

    override suspend fun getInCompleteMissions(userId: Long): Result<List<MissionData>> {
        val missions = kotlin.runCatching {
            service.getAllMissions(userId).filter { !it.isCompleted }.toData()
        }
        return classifyResult(missions)
    }
}
