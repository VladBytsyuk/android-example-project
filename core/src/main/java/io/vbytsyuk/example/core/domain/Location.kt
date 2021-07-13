package io.vbytsyuk.example.core.domain

data class Location(
    override val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
) : Item
