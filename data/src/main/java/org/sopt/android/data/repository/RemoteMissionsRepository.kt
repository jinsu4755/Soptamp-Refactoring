package org.sopt.android.data.repository

import org.sopt.android.data.error.ErrorData
import org.sopt.android.data.mapper.toDomain
import org.sopt.android.data.source.MissionsDataSource
import org.sopt.android.domain.model.Mission
import org.sopt.android.domain.repository.MissionsRepository
import javax.inject.Inject

internal class RemoteMissionsRepository @Inject constructor(
    private val dataSource: MissionsDataSource
) : MissionsRepository {
    override suspend fun getAllMissions(userId: Long): Result<List<Mission>> {
        val missions = dataSource.getAllMissions(userId).mapCatching {
            it.toDomain()
        }
        val exception = missions.exceptionOrNull()
        return if (exception is ErrorData) {
            Result.failure(exception.toDomain())
        } else {
            missions
        }
    }

    override suspend fun getCompleteMissions(userId: Long): Result<List<Mission>> {
        val missions = dataSource.getCompleteMissions(userId).mapCatching {
            it.toDomain()
        }
        val exception = missions.exceptionOrNull()
        return if (exception is ErrorData) {
            Result.failure(exception.toDomain())
        } else {
            missions
        }
    }

    override suspend fun getInCompleteMissions(userId: Long): Result<List<Mission>> {
        val missions = dataSource.getInCompleteMissions(userId).mapCatching {
            it.toDomain()
        }
        val exception = missions.exceptionOrNull()
        return if (exception is ErrorData) {
            Result.failure(exception.toDomain())
        } else {
            missions
        }
    }
}
