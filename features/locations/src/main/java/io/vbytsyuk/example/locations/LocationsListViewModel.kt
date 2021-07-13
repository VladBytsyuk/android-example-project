package io.vbytsyuk.example.locations

import io.vbytsyuk.example.core.ListViewModel
import io.vbytsyuk.example.core.domain.Location
import io.vbytsyuk.example.core.repository.Repository

class LocationsListViewModel(repository: Repository<List<Location>>) : ListViewModel<Location>(repository)

