package io.vbytsyuk.example.core.domain.list

data class PagingInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?,
)
