package io.vbytsyuk.example.core.api.domain

import io.vbytsyuk.example.core.api.ApiProvider
import io.vbytsyuk.example.core.domain.Location
import io.vbytsyuk.example.core.domain.list.ListData


interface LocationsApiProvider : ApiProvider<ListData<Location>>
