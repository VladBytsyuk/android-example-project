package io.vbytsyuk.example.api.providers

import io.vbytsyuk.example.api.ext.makeApiCall
import io.vbytsyuk.example.api.retrofit.RetrofitApi
import io.vbytsyuk.example.api.retrofit.RetrofitProvider
import io.vbytsyuk.example.core.api.ApiResult
import io.vbytsyuk.example.core.api.domain.EpisodesApiProvider
import io.vbytsyuk.example.core.domain.Episode
import io.vbytsyuk.example.core.domain.list.ListData

internal class RetrofitEpisodesApiProvider(
    private val retrofitProvider: RetrofitProvider
) : EpisodesApiProvider {
    private val retrofitApi: RetrofitApi get() = retrofitProvider.provideRetrofitApi()

    override suspend fun fetchData(page: Int): ApiResult<ListData<Episode>> =
        makeApiCall { retrofitApi.fetchEpisodes(page) }
}
