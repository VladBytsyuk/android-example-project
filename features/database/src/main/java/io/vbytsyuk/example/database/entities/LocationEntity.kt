package io.vbytsyuk.example.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class LocationEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
)
