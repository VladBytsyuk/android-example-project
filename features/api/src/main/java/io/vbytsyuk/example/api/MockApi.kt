package io.vbytsyuk.example.api

import io.vbytsyuk.example.core.api.ApiResult
import io.vbytsyuk.example.core.api.domain.CharactersApiProvider
import io.vbytsyuk.example.core.api.domain.EpisodesApiProvider
import io.vbytsyuk.example.core.api.domain.LocationsApiProvider
import io.vbytsyuk.example.core.domain.Character
import io.vbytsyuk.example.core.domain.Episode
import io.vbytsyuk.example.core.domain.Location
import kotlinx.coroutines.delay

class MockLocationsApi(private val value: List<Location>) : LocationsApiProvider {
    override suspend fun fetchData(): ApiResult<List<Location>> {
        delay(500)
        return ApiResult.Success(value)
    }
}

class MockCharactersApi(private val value: List<Character>) : CharactersApiProvider {
    override suspend fun fetchData(): ApiResult<List<Character>> {
        delay(500)
        return ApiResult.Success(value)
    }
}

class MockEpisodesApi(private val value: List<Episode>) : EpisodesApiProvider {
    override suspend fun fetchData(): ApiResult<List<Episode>> {
        delay(500)
        return ApiResult.Success(value)
    }
}
