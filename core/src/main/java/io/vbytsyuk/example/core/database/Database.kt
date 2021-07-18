package io.vbytsyuk.example.core.database

interface Database<T> :
    DatabaseProvider<T>,
    DatabaseStorage<T>

interface DatabaseProvider<out T> {
    suspend fun loadData(): T
}

interface DatabaseStorage<in T> {
    suspend fun saveData(data: T)
    suspend fun clear()
}