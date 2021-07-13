package io.vbytsyuk.example.core.api.domain

import io.vbytsyuk.example.core.api.ApiProvider
import io.vbytsyuk.example.core.domain.Character

interface CharactersApiProvider : ApiProvider<List<Character>>