package org.sopt.android.domain.repository

import org.sopt.android.domain.model.Mission

interface MissionsRepository {
    suspend fun getAllMissions(userId: Long): Result<List<Mission>>
    suspend fun getCompleteMissions(userId: Long): Result<List<Mission>>
    suspend fun getInCompleteMissions(userId: Long): Result<List<Mission>>
}
