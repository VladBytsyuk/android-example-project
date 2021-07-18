package io.vbytsyuk.example.api.ext

import io.vbytsyuk.example.api.models.Response
import io.vbytsyuk.example.core.api.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

internal suspend fun <M : Any, R : Response<M>> makeApiCall(
    block: suspend () -> R
): ApiResult<M> =
    try {
        val response = withContext(Dispatchers.IO) { block() }
        ApiResult.Success(response.toModel())
    } catch (httpException: HttpException) {
        ApiResult.Error(
            code = httpException.code(),
            message = httpException.message(),
        )
    } catch (throwable: Throwable) {
        ApiResult.Failure(throwable)
    }
