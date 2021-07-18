package io.vbytsyuk.example.database.providers

import android.content.Context
import androidx.room.Room
import io.vbytsyuk.example.core.database.domain.LocationsDatabase
import io.vbytsyuk.example.core.domain.Location
import io.vbytsyuk.example.database.RoomDatabaseImpl
import io.vbytsyuk.example.database.entities.LocationEntity

internal class LocationsRoomDatabase(applicationContext: Context, databaseName: String) : LocationsDatabase {
    private val room = Room.databaseBuilder(
        applicationContext,
        RoomDatabaseImpl::class.java,
        databaseName
    ).build()

    override suspend fun loadData(): List<Location> =
        room.locationDao.loadAllLocations().map(::convertEntityIntoModel)

    override suspend fun saveData(data: List<Location>) =
        room.locationDao.saveLocations(data.map(::convertModelIntoEntity))

    override suspend fun clear() =
        room.locationDao.clearAll()

    private fun convertEntityIntoModel(entity: LocationEntity): Location = Location(
        id = entity.id,
        name = entity.name,
        type = entity.type,
        dimension = entity.dimension
    )

    private fun convertModelIntoEntity(model: Location): LocationEntity = LocationEntity(
        id = model.id,
        name = model.name,
        type = model.type,
        dimension = model.dimension
    )
}
