package io.vbytsyuk.example.locations.list

import android.widget.TextView
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import io.vbytsyuk.example.core.ListAdapter
import io.vbytsyuk.example.core.ListFragment
import io.vbytsyuk.example.core.domain.Location
import io.vbytsyuk.example.core.ext.navigate
import io.vbytsyuk.example.locations.R
import io.vbytsyuk.example.locations.detail.LocationDetailFragment
import io.vbytsyuk.example.locations.detail.LocationDetailFragmentArgs
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsListFragment : ListFragment<Location, LocationsListViewModel>() {

    override val listViewModel: LocationsListViewModel by viewModel()

    override val adapterParams = ListAdapter.Params<Location>(
        layoutId = R.layout.adapter_item_location
    ) { location, view ->
        view.findViewById<TextView>(R.id.tvName).text = location.name
        view.findViewById<TextView>(R.id.tvType).text = location.type
        view.findViewById<TextView>(R.id.tvDimension).text = location.dimension
        view.setOnClickListener {
            val action = LocationsListFragmentDirections.actionNavigationLocationsToNavigationLocationDetail(
                name = location.name,
                type = location.type,
                dimension = location.dimension
            )
            view.navigate(action)
        }
    }
}
