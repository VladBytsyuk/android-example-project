package io.vbytsyuk.example.core.api.domain

import io.vbytsyuk.example.core.api.ApiProvider
import io.vbytsyuk.example.core.domain.Episode
import io.vbytsyuk.example.core.domain.list.ListData

interface EpisodesApiProvider : ApiProvider<ListData<Episode>>
