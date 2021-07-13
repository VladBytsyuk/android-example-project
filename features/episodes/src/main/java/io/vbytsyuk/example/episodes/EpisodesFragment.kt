package io.vbytsyuk.example.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import io.vbytsyuk.example.core.BindingFragment
import io.vbytsyuk.example.episodes.databinding.FragmentEpisodesBinding

class EpisodesFragment : BindingFragment<FragmentEpisodesBinding>() {

    private val episodesViewModel: EpisodesViewModel by viewModels()

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentEpisodesBinding.inflate(inflater, container, attachToParent)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        bind { binding ->
            val textView: TextView = binding.textEpisodes
            episodesViewModel.text.observe(viewLifecycleOwner, { textView.text = it })
        }
        return root
    }
}
