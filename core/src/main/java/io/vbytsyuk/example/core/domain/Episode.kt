package io.vbytsyuk.example.core.domain

data class Episode(
    override val id: Int,
    val name: String,
    val airDate: String,
    val episodeCode: String,
) : Item
