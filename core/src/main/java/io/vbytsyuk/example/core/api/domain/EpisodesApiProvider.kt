package io.vbytsyuk.example.core.api.domain

import io.vbytsyuk.example.core.api.ApiProvider
import io.vbytsyuk.example.core.domain.Episode

interface EpisodesApiProvider : ApiProvider<List<Episode>>