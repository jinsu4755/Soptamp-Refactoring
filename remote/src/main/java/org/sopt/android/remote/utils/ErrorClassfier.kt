package org.sopt.android.remote.utils

import org.sopt.android.data.ErrorData
import org.sopt.android.remote.mapper.toErrorDataResult
import retrofit2.HttpException
import java.net.UnknownHostException

fun <T> classifyResult(result: Result<T>): Result<T> {
    return when (val exception = result.exceptionOrNull()) {
        null -> result
        is UnknownHostException -> Result.failure(ErrorData.NetWorkUnavailable)
        is HttpException -> exception.toErrorDataResult()
        else -> Result.failure(exception)
    }
}
