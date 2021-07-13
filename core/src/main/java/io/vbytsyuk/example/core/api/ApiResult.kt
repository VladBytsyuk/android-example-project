package io.vbytsyuk.example.core.api

sealed class ApiResult<T> {
    data class Success<T>(val content: T) : ApiResult<T>()
    data class Error(val code: Int, val message: String) : ApiResult<Nothing>()
    data class Failure(val throwable: Throwable) : ApiResult<Nothing>()
}
