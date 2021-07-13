package io.vbytsyuk.example.episodes

import io.vbytsyuk.example.core.ListViewModel
import io.vbytsyuk.example.core.MockRepository
import io.vbytsyuk.example.core.domain.Episode

class EpisodesViewModel : ListViewModel<Episode>(
    repository = MockRepository(value = emptyList())
)
