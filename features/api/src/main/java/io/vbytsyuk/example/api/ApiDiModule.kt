package io.vbytsyuk.example.api

import io.vbytsyuk.example.core.api.domain.CharactersApiProvider
import io.vbytsyuk.example.core.api.domain.EpisodesApiProvider
import io.vbytsyuk.example.core.api.domain.LocationsApiProvider
import io.vbytsyuk.example.core.di.DiModule
import io.vbytsyuk.example.core.domain.Character
import io.vbytsyuk.example.core.domain.Location
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
        override val locationsApiProvider: LocationsApiProvider =
            MockLocationsApi(
                value = listOf(
                    Location(id = 1, name = "Home", type = "Building", dimension = "Earth"),
                    Location(id = 2, name = "Work", type = "Building", dimension = "Earth"),
                    Location(id = 3, name = "Diagon alley", type = "Street", dimension = "Harry Potter universe"),
                    Location(id = 4, name = "Tavern", type = "Building", dimension = "Earth"),
                    Location(id = 5, name = "Goldshire", type = "Town", dimension = "Azeroth"),
                    Location(id = 6, name = "Blackrock", type = "Rock", dimension = "Azeroth"),
                    Location(id = 7, name = "Konoha", type = "Town", dimension = "Naruto universe"),
                    Location(id = 8, name = "Omashu", type = "Town", dimension = "The last airbender universe"),
                )
            )

        override val charactersApiProvider: CharactersApiProvider =
            MockCharactersApi(
                value = listOf(
                    Character(id = 1, name = "Thrall", species = "Orc", status = "Alive", gender = "Male", imageUrl = "http://wow.blizzwiki.ru/images/2/23/Thrall-WC3.jpg", locationName = "Azeroth")
                )
            )

        override val episodesApiProvider: EpisodesApiProvider =
            MockEpisodesApi(value = emptyList())
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
