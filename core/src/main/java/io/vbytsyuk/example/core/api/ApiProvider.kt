package io.vbytsyuk.example.core.api

interface ApiProvider<T> {
    suspend fun fetchData(from: Int = 0, count: Int = 20): ApiResult<T>
}
