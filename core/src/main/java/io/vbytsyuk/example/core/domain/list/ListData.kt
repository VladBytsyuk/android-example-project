package io.vbytsyuk.example.core.domain.list


data class ListData<M>(
    val pagingInfo: PagingInfo,
    val list: List<M>
)
