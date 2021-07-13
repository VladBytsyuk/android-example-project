package io.vbytsyuk.example.database

import io.vbytsyuk.example.core.database.domain.CharactersDatabase
import io.vbytsyuk.example.core.database.domain.EpisodesDatabase
import io.vbytsyuk.example.core.database.domain.LocationsDatabase
import io.vbytsyuk.example.core.di.DiModule
import org.koin.core.module.Module
import org.koin.dsl.module


class DatabaseDiModule(dependencies: Dependencies) :
    DiModule<DatabaseDiModule.Dependencies, DatabaseDiModule.Api>(dependencies) {

    interface Dependencies : DiModule.Dependencies

    interface Api : DiModule.Api {
        val locationsDatabase: LocationsDatabase
        val charactersDatabase: CharactersDatabase
        val episodesDatabase: EpisodesDatabase
    }

    override val api: Api = object : Api {
        override val locationsDatabase: LocationsDatabase = MockLocationsDatabase (value = emptyList())
        override val charactersDatabase: CharactersDatabase = MockCharactersDatabase (value = emptyList())
        override val episodesDatabase: EpisodesDatabase = MockEpisodesDatabase (value = emptyList())
    }

    companion object {
        val koinModule: Module = module {
            single { DatabaseDiModule(dependencies = object : Dependencies { }) }
            single { get<DatabaseDiModule>().api.locationsDatabase }
            single { get<DatabaseDiModule>().api.charactersDatabase }
            single { get<DatabaseDiModule>().api.episodesDatabase }
        }
    }
}
