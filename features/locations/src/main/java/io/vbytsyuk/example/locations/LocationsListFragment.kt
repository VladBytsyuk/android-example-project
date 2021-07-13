package io.vbytsyuk.example.locations

import androidx.fragment.app.viewModels
import io.vbytsyuk.example.core.ListFragment
import io.vbytsyuk.example.core.domain.Location

class LocationsListFragment : ListFragment<Location, LocationsListViewModel>() {

    override val listViewModel: LocationsListViewModel by viewModels()

}
