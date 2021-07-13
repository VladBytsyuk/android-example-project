package io.vbytsyuk.example.core.domain

interface Item {
    val id: Int
    override fun equals(item: Any?): Boolean
}
