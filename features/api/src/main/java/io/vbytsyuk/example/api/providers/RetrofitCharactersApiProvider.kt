package io.vbytsyuk.example.api.providers

import io.vbytsyuk.example.api.ext.makeApiCall
import io.vbytsyuk.example.api.retrofit.RetrofitApi
import io.vbytsyuk.example.api.retrofit.RetrofitProvider
import io.vbytsyuk.example.core.api.ApiResult
import io.vbytsyuk.example.core.api.domain.CharactersApiProvider
import io.vbytsyuk.example.core.domain.Character
import io.vbytsyuk.example.core.domain.list.ListData

internal class RetrofitCharactersApiProvider(
    private val retrofitProvider: RetrofitProvider
) : CharactersApiProvider {
    private val retrofitApi: RetrofitApi get() = retrofitProvider.provideRetrofit()

    override suspend fun fetchData(page: Int): ApiResult<ListData<Character>> =
        makeApiCall { retrofitApi.fetchCharacters(page) }
}
