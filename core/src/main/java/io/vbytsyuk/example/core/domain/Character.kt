package io.vbytsyuk.example.core.domain

data class Character(
    override val id: Int,
    val name: String,
    val species: String,
    val status: String,
    val gender: String,
    val imageUrl: String,
    val locationName: String,
) : Item
