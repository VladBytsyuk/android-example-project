package io.vbytsyuk.example.episodes.list

import android.widget.TextView
import io.vbytsyuk.example.core.ListAdapter
import io.vbytsyuk.example.core.ListFragment
import io.vbytsyuk.example.core.domain.Episode
import io.vbytsyuk.example.core.ext.navigate
import io.vbytsyuk.example.episodes.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodesListFragment : ListFragment<Episode, EpisodesListViewModel>() {

    override val listViewModel: EpisodesListViewModel by viewModel()

    override val adapterParams = ListAdapter.Params<Episode>(layoutId = R.layout.adapter_item_episode) { episode, view ->
        view.findViewById<TextView>(R.id.tvName).text = episode.name
        view.findViewById<TextView>(R.id.tvAirDate).text = episode.airDate
        view.findViewById<TextView>(R.id.tvEpisode).text = episode.episodeCode
        view.setOnClickListener {
            val action = EpisodesListFragmentDirections.actionNavigationEpisodesToNavigationEpisodeDetail(
                name = episode.name,
                airDate = episode.airDate,
                episodeCode = episode.episodeCode
            )
            view.navigate(action)
        }
    }
}
