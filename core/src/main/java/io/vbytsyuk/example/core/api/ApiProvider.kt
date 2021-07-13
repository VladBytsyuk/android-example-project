package io.vbytsyuk.example.core.api

interface ApiProvider<T> {
    suspend fun fetchData(): ApiResult<T>
}
