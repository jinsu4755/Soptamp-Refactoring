package org.sopt.android.domain.error

sealed class Error(
    override val message: String? = null,
    override val cause: Throwable? = null
) : Exception(message, cause) {
    object NetWorkUnavailable : Error()
    object BadRequest : Error()
    object Unauthorized : Error()
    object Forbidden : Error()
    object NotFound : Error()
    object ServerError : Error()
    data class NotUsefulCredentials(override val message: String?) : Error(message)
}
