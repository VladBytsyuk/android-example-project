package io.vbytsyuk.example.locations.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import io.vbytsyuk.example.core.ext.DetailFragment
import io.vbytsyuk.example.locations.databinding.FragmentDetailLocationBinding

class LocationDetailFragment : DetailFragment<FragmentDetailLocationBinding>() {
    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentDetailLocationBinding.inflate(inflater, container, attachToParent)
}
