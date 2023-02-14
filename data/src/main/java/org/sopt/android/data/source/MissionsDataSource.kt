package org.sopt.android.data.source

import org.sopt.android.data.model.MissionData

interface MissionsDataSource {
    suspend fun getAllMissions(userId: Long): Result<List<MissionData>>
    suspend fun getCompleteMissions(userId: Long): Result<List<MissionData>>
    suspend fun getInCompleteMissions(userId: Long): Result<List<MissionData>>
}
