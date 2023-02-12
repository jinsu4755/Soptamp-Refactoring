package org.sopt.android.data

sealed class ErrorData(
    override val message: String? = null,
    override val cause: Throwable? = null
) : Exception(message, cause) {
    object NetWorkUnavailable : ErrorData()
    object BadRequest : ErrorData()
    object Unauthorized : ErrorData()
    object Forbidden : ErrorData()
    object NotFound : ErrorData()
    object ServerError : ErrorData()
}
