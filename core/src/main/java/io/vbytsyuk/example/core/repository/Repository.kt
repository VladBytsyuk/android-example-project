package io.vbytsyuk.example.core.repository

import kotlinx.coroutines.flow.Flow

interface Repository<T> {
    fun dataFlow(): Flow<T>
}
