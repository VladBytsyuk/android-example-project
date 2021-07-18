package io.vbytsyuk.example.core.api

interface ApiProvider<T> {
    suspend fun fetchData(page: Int = 0): ApiResult<T>
}
