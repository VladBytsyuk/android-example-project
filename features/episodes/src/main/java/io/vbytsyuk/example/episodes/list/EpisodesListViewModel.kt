package io.vbytsyuk.example.episodes.list

import io.vbytsyuk.example.core.list.ListViewModel
import io.vbytsyuk.example.core.domain.Episode
import io.vbytsyuk.example.core.repository.Repository

class EpisodesListViewModel(repository: Repository<Episode>) : ListViewModel<Episode>(repository)
