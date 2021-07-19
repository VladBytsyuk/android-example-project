package io.vbytsyuk.example.core.repository

import io.vbytsyuk.example.core.Logger
import io.vbytsyuk.example.core.api.ApiProvider
import io.vbytsyuk.example.core.api.ApiResult
import io.vbytsyuk.example.core.database.Database
import io.vbytsyuk.example.core.domain.list.ListData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow

internal class RepositoryImpl<out T>(
    private val logger: Logger,
    private val database: Database<List<T>>,
    private val apiProvider: ApiProvider<ListData<T>>,
) : Repository<T> {
    private var lastLoadedPage: Int = 0

    override suspend fun clearState() {
        lastLoadedPage = 0
        database.clear()
        logger.v(message = "Database cleared.")
    }

    override fun dataFlow(count: Int): Flow<List<T>> = flow {
        if (isFirstLoad) {
            val hasDatabaseCache = loadDatabaseList()
            if (hasDatabaseCache) return@flow
        }
        fetchApiList()
    }

    private val isFirstLoad: Boolean get() = lastLoadedPage == 0

    private suspend fun FlowCollector<List<T>>.loadDatabaseList(): Boolean {
        val databaseData = database.loadData()
        emit(databaseData)
        logger.v(message = "Database data [${databaseData.size} items] emitted.")
        setUpLastLoadedPage(databaseData)
        return lastLoadedPage != 0
    }

    private fun setUpLastLoadedPage(list: List<T>) {
        lastLoadedPage = list.size / 20
        if (list.size % 20 != 0) lastLoadedPage++
    }

    private suspend fun FlowCollector<List<T>>.fetchApiList() =
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
