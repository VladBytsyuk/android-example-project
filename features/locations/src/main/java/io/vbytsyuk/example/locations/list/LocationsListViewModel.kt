package io.vbytsyuk.example.locations.list

import io.vbytsyuk.example.core.list.ListViewModel
import io.vbytsyuk.example.core.domain.Location
import io.vbytsyuk.example.core.repository.Repository

class LocationsListViewModel(repository: Repository<Location>) : ListViewModel<Location>(repository)

