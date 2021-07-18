package io.vbytsyuk.example.core

import android.util.Log
import io.vbytsyuk.example.core.api.ApiProvider
import io.vbytsyuk.example.core.api.ApiResult
import io.vbytsyuk.example.core.database.Database
import io.vbytsyuk.example.core.repository.RepositoryImpl
import kotlinx.coroutines.delay

fun <T> MockRepository(value: List<T>) = RepositoryImpl(
    logger = object : Logger {
        override val tag: String
            get() = "Mock"

        override fun v(tag: String, message: String) {
            Log.v(tag, message)
        }

        override fun i(tag: String, message: String) {
            Log.i(tag, message)
        }

        override fun d(tag: String, message: String) {
            Log.d(tag, message)
        }

        override fun w(tag: String, message: String) {
            Log.w(tag, message)
        }

        override fun e(tag: String, message: String) {
            Log.e(tag, message)
        }

        override fun e(tag: String, throwable: Throwable) {
            Log.e(tag, null, throwable)
        }

        override fun f(tag: String, message: String) {
            Log.wtf(tag, message)
        }
    },
    database = object : Database<List<T>> {
        override suspend fun loadData(): List<T> {
            delay(200)
            return value
        }
        override suspend fun saveData(data: List<T>) = Unit
    },
    apiProvider = object : ApiProvider<List<T>> {
        override suspend fun fetchData(from: Int, count: Int): ApiResult<List<T>> {
            delay(500)
            return ApiResult.Success(value)
        }
    }
)