package org.sopt.android.data.mapper

import org.sopt.android.data.ErrorData
import org.sopt.android.domain.error.Error

internal fun ErrorData.toDomain() = when (this) {
    ErrorData.NetWorkUnavailable -> Error.NetWorkUnavailable
    ErrorData.BadRequest -> Error.BadRequest
    ErrorData.Unauthorized -> Error.Unauthorized
    ErrorData.Forbidden -> Error.Forbidden
    ErrorData.NotFound -> Error.NotFound
    ErrorData.ServerError -> Error.ServerError
}
