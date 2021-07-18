package io.vbytsyuk.example.locations.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import io.vbytsyuk.example.core.ext.DetailFragment
import io.vbytsyuk.example.locations.databinding.FragmentDetailLocationBinding

class LocationDetailFragment : DetailFragment<FragmentDetailLocationBinding>() {
    private val args: LocationDetailFragmentArgs by navArgs()

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentDetailLocationBinding.inflate(inflater, container, attachToParent)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind { binding ->
            binding.tvName.text = args.name
            binding.tvType.text = args.type
            binding.tvDimension.text = args.dimension
        }
    }
}
