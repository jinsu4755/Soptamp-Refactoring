package org.sopt.android.remote.mapper

import org.sopt.android.data.ErrorData
import retrofit2.HttpException

fun <T> HttpException.toErrorDataResult(): Result<T> = when (this.code()) {
    400 -> Result.failure(ErrorData.BadRequest)
    401 -> Result.failure(ErrorData.Unauthorized)
    403 -> Result.failure(ErrorData.Forbidden)
    404 -> Result.failure(ErrorData.NotFound)
    else -> Result.failure(ErrorData.ServerError)
}
