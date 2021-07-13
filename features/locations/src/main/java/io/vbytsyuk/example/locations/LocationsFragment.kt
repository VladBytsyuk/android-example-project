package io.vbytsyuk.example.locations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import io.vbytsyuk.example.core.ListBindingFragment
import io.vbytsyuk.example.core.domain.Location
import io.vbytsyuk.example.locations.databinding.FragmentLocationsBinding

class LocationsFragment : ListBindingFragment<Location, FragmentLocationsBinding>() {

    private val locationsViewModel: LocationsViewModel by viewModels()

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentLocationsBinding.inflate(inflater, container, false)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        bind { binding ->
            val textView: TextView = binding.textLocations
            locationsViewModel.text.observe(viewLifecycleOwner, { textView.text = it })
        }
        return root
    }
}
