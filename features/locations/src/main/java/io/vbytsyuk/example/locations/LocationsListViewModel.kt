package io.vbytsyuk.example.locations

import io.vbytsyuk.example.core.ListViewModel
import io.vbytsyuk.example.core.MockRepository
import io.vbytsyuk.example.core.domain.Location

class LocationsListViewModel : ListViewModel<Location>(
    repository = MockRepository(
        value = listOf(
            Location(id = 1, name = "Home", type = "Building", dimension = "Earth"),
            Location(id = 2, name = "Work", type = "Building", dimension = "Earth"),
            Location(id = 3, name = "Diagon alley", type = "Park", dimension = "Harry Potter universe"),
            Location(id = 4, name = "Tavern", type = "Building", dimension = "Earth"),
            Location(id = 5, name = "Goldshire", type = "Town", dimension = "Azeroth"),
            Location(id = 6, name = "Blackrock", type = "Rock", dimension = "Azeroth"),
            Location(id = 7, name = "Konoha", type = "Town", dimension = "Naruto universe"),
            Location(id = 8, name = "Omashu", type = "Town", dimension = "The last airbender universe"),
        )
    )
)
