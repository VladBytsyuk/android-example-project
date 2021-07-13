package io.vbytsyuk.example.database

import io.vbytsyuk.example.core.database.domain.CharactersDatabase
import io.vbytsyuk.example.core.database.domain.EpisodesDatabase
import io.vbytsyuk.example.core.database.domain.LocationsDatabase
import io.vbytsyuk.example.core.domain.Character
import io.vbytsyuk.example.core.domain.Episode
import io.vbytsyuk.example.core.domain.Location
import kotlinx.coroutines.delay

class MockLocationsDatabase(private val value: List<Location>) : LocationsDatabase {
    override suspend fun loadData(): List<Location> {
        delay(200)
        return value
    }

    override suspend fun saveData(data: List<Location>) = Unit
}

class MockCharactersDatabase(private val value: List<Character>) : CharactersDatabase {
    override suspend fun loadData(): List<Character> {
        delay(200)
        return value
    }

    override suspend fun saveData(data: List<Character>) = Unit
}

class MockEpisodesDatabase(private val value: List<Episode>) : EpisodesDatabase {
    override suspend fun loadData(): List<Episode> {
        delay(200)
        return value
    }

    override suspend fun saveData(data: List<Episode>) = Unit
}
