package io.vbytsyuk.example.episodes.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import io.vbytsyuk.example.core.ext.DetailFragment
import io.vbytsyuk.example.episodes.databinding.FragmentDetailEpisodeBinding

class EpisodeDetailFragment : DetailFragment<FragmentDetailEpisodeBinding>() {
    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentDetailEpisodeBinding.inflate(inflater, container, attachToParent)
}
