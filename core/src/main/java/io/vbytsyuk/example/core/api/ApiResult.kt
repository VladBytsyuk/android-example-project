package io.vbytsyuk.example.core.api

sealed class ApiResult<T> {
    data class Success<T>(val content: T) : ApiResult<T>()
    data class Error<T>(val code: Int, val message: String) : ApiResult<T>()
    data class Failure<T>(val throwable: Throwable) : ApiResult<T>()
}
