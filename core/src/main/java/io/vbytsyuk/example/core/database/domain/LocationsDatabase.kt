package io.vbytsyuk.example.core.database.domain

import io.vbytsyuk.example.core.database.Database
import io.vbytsyuk.example.core.domain.Location

interface LocationsDatabase : Database<List<Location>>
