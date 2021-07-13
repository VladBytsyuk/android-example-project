package io.vbytsyuk.example.locations

import androidx.fragment.app.viewModels
import io.vbytsyuk.example.core.ListFragment
import io.vbytsyuk.example.core.domain.Location

class LocationsFragment : ListFragment<Location>() {

    private val locationsViewModel: LocationsViewModel by viewModels()

}
