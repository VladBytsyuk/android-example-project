package io.vbytsyuk.example.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class CharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val species: String,
    val status: String,
    val gender: String,
    val imageUrl: String,
    val locationName: String,
)
