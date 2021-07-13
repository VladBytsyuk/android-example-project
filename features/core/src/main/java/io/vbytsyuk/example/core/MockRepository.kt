package io.vbytsyuk.example.core

import android.util.Log
import io.vbytsyuk.example.core.api.ApiProvider
import io.vbytsyuk.example.core.api.ApiResult
import io.vbytsyuk.example.core.database.Database
import io.vbytsyuk.example.core.repository.RepositoryImpl

fun <T> MockRepository(value: T) = RepositoryImpl<T>(
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

        override fun f(tag: String, message: String) {
            Log.wtf(tag, message)
        }
    },
    database = object : Database<T> {
        override suspend fun loadData(): T = value
        override suspend fun saveData(data: T) = Unit
    },
    apiProvider = object : ApiProvider<T> {
        override suspend fun fetchData(): ApiResult<T> = ApiResult.Success<T>(value)
    }
)