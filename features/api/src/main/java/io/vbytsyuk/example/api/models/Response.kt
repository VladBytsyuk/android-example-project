package io.vbytsyuk.example.api.models

internal interface Response<M> {
    fun toModel(): M
}
