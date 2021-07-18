package io.vbytsyuk.example.api.models

import com.squareup.moshi.JsonClass
import io.vbytsyuk.example.core.domain.list.ListData

@JsonClass(generateAdapter = true)
internal data class ListDataResponse<M, R : Response<M>>(
    val info: PagingInfoResponse,
    val results: List<R>
) : Response<ListData<M>> {
    override fun toModel() = ListData(
        pagingInfo = info.toModel(),
        list = results.map { it.toModel() }
    )
}
