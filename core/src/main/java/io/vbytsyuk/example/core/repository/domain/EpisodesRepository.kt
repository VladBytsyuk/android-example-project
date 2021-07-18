package io.vbytsyuk.example.core.repository.domain

import io.vbytsyuk.example.core.Logger
import io.vbytsyuk.example.core.api.domain.EpisodesApiProvider
import io.vbytsyuk.example.core.database.domain.EpisodesDatabase
import io.vbytsyuk.example.core.domain.Episode
import io.vbytsyuk.example.core.repository.Repository
import io.vbytsyuk.example.core.repository.RepositoryImpl

class EpisodesRepository(logger: Logger, database: EpisodesDatabase, apiProvider: EpisodesApiProvider) :
    Repository<Episode> by RepositoryImpl(logger, database, apiProvider)
