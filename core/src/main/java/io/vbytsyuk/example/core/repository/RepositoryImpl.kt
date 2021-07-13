package io.vbytsyuk.example.core.repository

import io.vbytsyuk.example.core.Logger
import io.vbytsyuk.example.core.api.ApiProvider
import io.vbytsyuk.example.core.api.ApiResult
import io.vbytsyuk.example.core.database.Database
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl<T>(
    private val logger: Logger,
    private val database: Database<T>,
    private val apiProvider: ApiProvider<T>,
) : Repository<T> {
    override fun dataFlow(): Flow<T> = flow {
        val databaseData = database.loadData()
        emit(databaseData)
        logger.v(message = "Database data emitted.")

        when (val apiData = apiProvider.fetchData()) {
            is ApiResult.Success -> {
                emit(apiData.content)
                logger.v(message = "Api data emitted.")

                database.saveData(apiData.content)
                logger.v(message = "Api data saved to database.")
            }
            is ApiResult.Error -> {
                logger.e(message = "Response error. [$apiData]")
            }
            is ApiResult.Failure -> {
                logger.e(message = "Request failure. [${apiData.throwable.message}]")
            }
        }
    }
}
