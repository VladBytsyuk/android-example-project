package io.vbytsyuk.example.episodes

import androidx.fragment.app.viewModels
import io.vbytsyuk.example.core.ListFragment
import io.vbytsyuk.example.core.domain.Episode

class EpisodesListFragment : ListFragment<Episode, EpisodesListViewModel>() {

    override val listViewModel: EpisodesListViewModel by viewModels()

}
