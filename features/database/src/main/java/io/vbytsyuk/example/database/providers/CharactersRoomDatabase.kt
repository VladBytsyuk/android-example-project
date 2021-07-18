package io.vbytsyuk.example.database.providers

import android.content.Context
import androidx.room.Room
import io.vbytsyuk.example.core.database.domain.CharactersDatabase
import io.vbytsyuk.example.core.domain.Character
import io.vbytsyuk.example.database.RoomDatabaseImpl
import io.vbytsyuk.example.database.entities.CharacterEntity

internal class CharactersRoomDatabase(applicationContext: Context, databaseName: String) : CharactersDatabase {
    private val room = Room.databaseBuilder(
        applicationContext,
        RoomDatabaseImpl::class.java,
        databaseName
    ).build()

    override suspend fun loadData(): List<Character> =
        room.characterDao.loadAllCharacters().map(::convertEntityIntoModel)

    override suspend fun saveData(data: List<Character>) =
        room.characterDao.saveCharacters(data.map(::convertModelIntoEntity))

    override suspend fun clear() =
        room.characterDao.clearAll()

    private fun convertEntityIntoModel(entity: CharacterEntity): Character = Character(
        id = entity.id,
        name = entity.name,
        species = entity.name,
        status = entity.name,
        gender = entity.gender,
        imageUrl = entity.imageUrl,
        locationName = entity.locationName
    )

    private fun convertModelIntoEntity(model: Character): CharacterEntity = CharacterEntity(
        id = model.id,
        name = model.name,
        species = model.name,
        status = model.name,
        gender = model.gender,
        imageUrl = model.imageUrl,
        locationName = model.locationName
    )
}
