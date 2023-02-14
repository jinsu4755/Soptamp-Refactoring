package org.sopt.android.remote.api

import org.sopt.android.remote.model.response.MissionResponse
import retrofit2.http.GET
import retrofit2.http.Header

internal interface MissionsService {
    @GET("mission/all")
    suspend fun getAllMissions(@Header("userId") userId: Long): List<MissionResponse>
}
