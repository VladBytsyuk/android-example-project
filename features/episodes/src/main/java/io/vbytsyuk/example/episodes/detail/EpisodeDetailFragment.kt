package io.vbytsyuk.example.episodes.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import io.vbytsyuk.example.core.DetailFragment
import io.vbytsyuk.example.episodes.databinding.FragmentDetailEpisodeBinding

class EpisodeDetailFragment : DetailFragment<FragmentDetailEpisodeBinding>() {
    private val args: EpisodeDetailFragmentArgs by navArgs()

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentDetailEpisodeBinding.inflate(inflater, container, attachToParent)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind { binding ->
            binding.tvName.text = args.name
            binding.tvAirDate.text = args.airDate
            binding.tvEpisodeCode.text = args.episodeCode
        }
    }
}
