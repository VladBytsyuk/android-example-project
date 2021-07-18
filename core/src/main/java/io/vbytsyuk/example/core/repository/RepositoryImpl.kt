package io.vbytsyuk.example.core.repository

import io.vbytsyuk.example.core.Logger
import io.vbytsyuk.example.core.api.ApiProvider
import io.vbytsyuk.example.core.api.ApiResult
import io.vbytsyuk.example.core.database.Database
import io.vbytsyuk.example.core.domain.list.ListData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl<out T>(
    private val logger: Logger,
    private val database: Database<List<T>>,
    private val apiProvider: ApiProvider<ListData<T>>,
) : Repository<T> {
    private var lastLoadedPage: Int = 0

    override fun dataFlow(count: Int): Flow<List<T>> = flow {
        if (lastLoadedPage == 0) {
            val databaseData = database.loadData()
            emit(databaseData)
            logger.v(message = "Database data [${databaseData.size} items] emitted.")
        }
        when (val apiData = apiProvider.fetchData(lastLoadedPage + 1)) {
            is ApiResult.Success -> {
                lastLoadedPage += 1
                val apiList = apiData.content.list
                emit(apiList)
                logger.v(message = "Api data [${apiList.size} items from page $lastLoadedPage] emitted.")

                database.saveData(apiList)
                logger.v(message = "Api data [${apiList.size} items] saved to database.")
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
        lastLoadedPage = 0
    }
}
