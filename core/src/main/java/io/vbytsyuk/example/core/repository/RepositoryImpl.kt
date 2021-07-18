package io.vbytsyuk.example.core.repository

import io.vbytsyuk.example.core.Logger
import io.vbytsyuk.example.core.api.ApiProvider
import io.vbytsyuk.example.core.api.ApiResult
import io.vbytsyuk.example.core.database.Database
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl<out T>(
    private val logger: Logger,
    private val database: Database<List<T>>,
    private val apiProvider: ApiProvider<List<T>>,
) : Repository<T> {
    private var nextLoadIndex: Int = 0

    override fun dataFlow(count: Int): Flow<List<T>> = flow {
        if (nextLoadIndex == 0) {
            val databaseData = database.loadData()
            emit(databaseData)
            logger.v(message = "Database data [${databaseData.size} items] emitted.")
        }
        when (val apiData = apiProvider.fetchData(nextLoadIndex, count)) {
            is ApiResult.Success -> {
                emit(apiData.content)
                logger.v(message = "Api data [${apiData.content.size} items] emitted.")

                nextLoadIndex += apiData.content.size

                database.saveData(apiData.content)
                logger.v(message = "Api data [${apiData.content.size} items] saved to database.")
            }
            is ApiResult.Error -> {
                logger.e(message = "Response error. [$apiData]")
            }
            is ApiResult.Failure -> {
                logger.e(message = "Request failure. [${apiData.throwable.message}]")
            }
        }
    }

    override fun clearState() {
        nextLoadIndex = 0
    }
}
