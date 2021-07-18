package io.vbytsyuk.example.core.api.domain

import io.vbytsyuk.example.core.api.ApiProvider
import io.vbytsyuk.example.core.domain.Character
import io.vbytsyuk.example.core.domain.list.ListData

interface CharactersApiProvider : ApiProvider<ListData<Character>>
