package io.vbytsyuk.example.locations

import io.vbytsyuk.example.core.ListViewModel
import io.vbytsyuk.example.core.MockRepository
import io.vbytsyuk.example.core.domain.Location

class LocationsListViewModel : ListViewModel<Location>(
    repository = MockRepository(value = emptyList())
)
