package io.vbytsyuk.example.api

import io.vbytsyuk.example.api.providers.CharactersApiProviderImpl
import io.vbytsyuk.example.api.providers.EpisodesApiProviderImpl
import io.vbytsyuk.example.api.providers.LocationsApiProviderImpl
import io.vbytsyuk.example.api.retrofit.RetrofitProvider
import io.vbytsyuk.example.core.api.domain.CharactersApiProvider
import io.vbytsyuk.example.core.api.domain.EpisodesApiProvider
import io.vbytsyuk.example.core.api.domain.LocationsApiProvider
import io.vbytsyuk.example.core.di.DiModule
import org.koin.core.module.Module
import org.koin.dsl.module

class ApiDiModule(dependencies: Dependencies) :
    DiModule<ApiDiModule.Dependencies, ApiDiModule.Api>(dependencies) {

    interface Dependencies : DiModule.Dependencies

    interface Api : DiModule.Api {
        val locationsApiProvider: LocationsApiProvider
        val charactersApiProvider: CharactersApiProvider
        val episodesApiProvider: EpisodesApiProvider
    }

    override val api: Api = object : Api {
        private val retrofitProvider: RetrofitProvider
            get() = RetrofitProvider(url = "https://rickandmortyapi.com/")

        override val locationsApiProvider: LocationsApiProvider =
            LocationsApiProviderImpl(retrofitProvider)

        override val charactersApiProvider: CharactersApiProvider =
            CharactersApiProviderImpl(retrofitProvider)

        override val episodesApiProvider: EpisodesApiProvider =
            EpisodesApiProviderImpl(retrofitProvider)
    }

    companion object {
        val koinModule: Module = module {
            single { ApiDiModule(dependencies = object : Dependencies { }) }
            single { get<ApiDiModule>().api.locationsApiProvider }
            single { get<ApiDiModule>().api.charactersApiProvider }
            single { get<ApiDiModule>().api.episodesApiProvider }
        }
    }
}
