package io.vbytsyuk.example.core.repository.domain

import io.vbytsyuk.example.core.Logger
import io.vbytsyuk.example.core.api.domain.CharactersApiProvider
import io.vbytsyuk.example.core.database.domain.CharactersDatabase
import io.vbytsyuk.example.core.domain.Character
import io.vbytsyuk.example.core.repository.Repository
import io.vbytsyuk.example.core.repository.RepositoryImpl

class CharactersRepository(logger: Logger, database: CharactersDatabase, apiProvider: CharactersApiProvider) :
    Repository<List<Character>> by RepositoryImpl(logger, database, apiProvider)
