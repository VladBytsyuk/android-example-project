package io.vbytsyuk.example.episodes

import androidx.fragment.app.viewModels
import io.vbytsyuk.example.core.ListFragment
import io.vbytsyuk.example.core.domain.Episode

class EpisodesFragment : ListFragment<Episode, EpisodesViewModel>() {

    override val viewModel: EpisodesViewModel by viewModels()

}
