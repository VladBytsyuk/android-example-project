package io.vbytsyuk.example.api.models

import com.squareup.moshi.JsonClass
import io.vbytsyuk.example.core.domain.list.PagingInfo

@JsonClass(generateAdapter = true)
internal data class PagingInfoResponse(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?,
) : Response<PagingInfo> {
    override fun toModel() = PagingInfo(
        count = count,
        pages = pages,
        next = next,
        prev = prev
    )
}
