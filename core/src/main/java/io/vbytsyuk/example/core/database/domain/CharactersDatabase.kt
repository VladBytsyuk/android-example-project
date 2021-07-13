package io.vbytsyuk.example.core.database.domain

import io.vbytsyuk.example.core.database.Database
import io.vbytsyuk.example.core.domain.Character

interface CharactersDatabase : Database<List<Character>>
