package io.vbytsyuk.example.core.repository.domain

import io.vbytsyuk.example.core.Logger
import io.vbytsyuk.example.core.api.domain.LocationsApiProvider
import io.vbytsyuk.example.core.database.domain.LocationsDatabase
import io.vbytsyuk.example.core.domain.Location
import io.vbytsyuk.example.core.repository.Repository
import io.vbytsyuk.example.core.repository.RepositoryImpl

class LocationsRepository(logger: Logger, database: LocationsDatabase, apiProvider: LocationsApiProvider) :
    Repository<Location> by RepositoryImpl(logger, database, apiProvider)
