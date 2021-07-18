package io.vbytsyuk.example.database

import android.content.Context
import io.vbytsyuk.example.core.database.domain.CharactersDatabase
import io.vbytsyuk.example.core.database.domain.EpisodesDatabase
import io.vbytsyuk.example.core.database.domain.LocationsDatabase
import io.vbytsyuk.example.core.di.DiModule
import io.vbytsyuk.example.database.providers.CharactersRoomDatabase
import io.vbytsyuk.example.database.providers.EpisodesRoomDatabase
import io.vbytsyuk.example.database.providers.LocationsRoomDatabase
import org.koin.core.module.Module
import org.koin.dsl.module


class DatabaseDiModule(dependencies: Dependencies) :
    DiModule<DatabaseDiModule.Dependencies, DatabaseDiModule.Api>(dependencies) {

    interface Dependencies : DiModule.Dependencies {
        val applicationContext: Context
    }

    interface Api : DiModule.Api {
        val locationsDatabase: LocationsDatabase
        val charactersDatabase: CharactersDatabase
        val episodesDatabase: EpisodesDatabase
    }

    override val api: Api = object : Api {
        override val locationsDatabase: LocationsDatabase =
            LocationsRoomDatabase(dependencies.applicationContext, DATABASE_NAME)
        override val charactersDatabase: CharactersDatabase =
            CharactersRoomDatabase(dependencies.applicationContext, DATABASE_NAME)
        override val episodesDatabase: EpisodesDatabase =
            EpisodesRoomDatabase(dependencies.applicationContext, DATABASE_NAME)
    }

    companion object {
        private const val DATABASE_NAME = "cache_db"
        val koinModule: Module = module {
            single {
                DatabaseDiModule(
                    dependencies = object : Dependencies {
                        override val applicationContext: Context = get()
                    }
                )
            }
            single { get<DatabaseDiModule>().api.locationsDatabase }
            single { get<DatabaseDiModule>().api.charactersDatabase }
            single { get<DatabaseDiModule>().api.episodesDatabase }
        }
    }
}
