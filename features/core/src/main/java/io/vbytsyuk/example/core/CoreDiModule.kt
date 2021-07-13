package io.vbytsyuk.example.core

import io.vbytsyuk.example.core.api.domain.CharactersApiProvider
import io.vbytsyuk.example.core.api.domain.EpisodesApiProvider
import io.vbytsyuk.example.core.api.domain.LocationsApiProvider
import io.vbytsyuk.example.core.database.domain.CharactersDatabase
import io.vbytsyuk.example.core.database.domain.EpisodesDatabase
import io.vbytsyuk.example.core.database.domain.LocationsDatabase
import io.vbytsyuk.example.core.di.DiModule
import io.vbytsyuk.example.core.repository.domain.CharactersRepository
import io.vbytsyuk.example.core.repository.domain.EpisodesRepository
import io.vbytsyuk.example.core.repository.domain.LocationsRepository
import org.koin.core.module.Module
import org.koin.dsl.module

class CoreDiModule(dependencies: Dependencies) :
    DiModule<CoreDiModule.Dependencies, CoreDiModule.Api>(dependencies) {

    interface Dependencies : DiModule.Dependencies {
        val logger: Logger

        val locationsApiProvider: LocationsApiProvider
        val locationsDatabase: LocationsDatabase

        val charactersApiProvider: CharactersApiProvider
        val charactersDatabase: CharactersDatabase

        val episodesApiProvider: EpisodesApiProvider
        val episodesDatabase: EpisodesDatabase
    }

    interface Api : DiModule.Api {
        val locationsRepository: LocationsRepository
        val charactersRepository: CharactersRepository
        val episodesRepository: EpisodesRepository
    }

    override val api: Api = object : Api {
        override val locationsRepository: LocationsRepository =
            LocationsRepository(dependencies.logger, dependencies.locationsDatabase, dependencies.locationsApiProvider)

        override val charactersRepository: CharactersRepository =
            CharactersRepository(dependencies.logger, dependencies.charactersDatabase, dependencies.charactersApiProvider)

        override val episodesRepository: EpisodesRepository =
            EpisodesRepository(dependencies.logger, dependencies.episodesDatabase, dependencies.episodesApiProvider)
    }

    companion object {
        val koinModule: Module = module {
            single {
                CoreDiModule(
                    dependencies = object : Dependencies {
                        override val logger: Logger = get()

                        override val locationsApiProvider: LocationsApiProvider = get()
                        override val locationsDatabase: LocationsDatabase = get()

                        override val charactersApiProvider: CharactersApiProvider = get()
                        override val charactersDatabase: CharactersDatabase = get()

                        override val episodesApiProvider: EpisodesApiProvider = get()
                        override val episodesDatabase: EpisodesDatabase = get()
                    }
                )
            }
            single { get<CoreDiModule>().api.locationsRepository }
            single { get<CoreDiModule>().api.charactersRepository }
            single { get<CoreDiModule>().api.episodesRepository }
        }
    }
}