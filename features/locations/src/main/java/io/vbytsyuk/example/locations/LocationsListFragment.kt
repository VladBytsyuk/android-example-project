package io.vbytsyuk.example.locations

import android.widget.TextView
import io.vbytsyuk.example.core.ListAdapter
import io.vbytsyuk.example.core.ListFragment
import io.vbytsyuk.example.core.domain.Location
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsListFragment : ListFragment<Location, LocationsListViewModel>() {

    override val listViewModel: LocationsListViewModel by viewModel()

    override val adapterParams = ListAdapter.Params<Location>(layoutId = R.layout.adapter_item_location) { location, view ->
        view.findViewById<TextView>(R.id.tvName).text = location.name
        view.findViewById<TextView>(R.id.tvType).text = location.type
        view.findViewById<TextView>(R.id.tvDimension).text = location.dimension
    }
}
