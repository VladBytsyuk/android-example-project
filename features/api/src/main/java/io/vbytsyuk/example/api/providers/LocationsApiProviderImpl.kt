package io.vbytsyuk.example.api.providers

import io.vbytsyuk.example.api.ext.makeApiCall
import io.vbytsyuk.example.api.retrofit.RetrofitApi
import io.vbytsyuk.example.api.retrofit.RetrofitProvider
import io.vbytsyuk.example.core.api.ApiResult
import io.vbytsyuk.example.core.api.domain.LocationsApiProvider
import io.vbytsyuk.example.core.domain.Location
import io.vbytsyuk.example.core.domain.list.ListData

internal class LocationsApiProviderImpl(
    private val retrofitProvider: RetrofitProvider
) : LocationsApiProvider {
    private val retrofitApi: RetrofitApi get() = retrofitProvider.provideRetrofit()

    override suspend fun fetchData(page: Int): ApiResult<ListData<Location>> =
        makeApiCall { retrofitApi.fetchLocations(page) }
}
