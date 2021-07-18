package io.vbytsyuk.example.core.repository

import kotlinx.coroutines.flow.Flow

interface Repository<out T> {
    fun dataFlow(count: Int = 20): Flow<List<T>>
    suspend fun clearState()
}
