package io.vbytsyuk.example.episodes

import android.widget.TextView
import androidx.fragment.app.viewModels
import io.vbytsyuk.example.core.ListAdapter
import io.vbytsyuk.example.core.ListFragment
import io.vbytsyuk.example.core.domain.Episode

class EpisodesListFragment : ListFragment<Episode, EpisodesListViewModel>() {

    override val listViewModel: EpisodesListViewModel by viewModels()
    override val adapterParams = ListAdapter.Params<Episode>(layoutId = R.layout.adapter_item_episode) { episode, view ->
        view.findViewById<TextView>(R.id.tvName).text = episode.name
        view.findViewById<TextView>(R.id.tvAirDate).text = episode.airDate
        view.findViewById<TextView>(R.id.tvEpisode).text = episode.episodeCode
    }
}
