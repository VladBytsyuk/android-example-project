package io.vbytsyuk.example.characters

import io.vbytsyuk.example.core.ListViewModel
import io.vbytsyuk.example.core.MockRepository
import io.vbytsyuk.example.core.domain.Character

class CharactersListViewModel : ListViewModel<Character>(
    repository = MockRepository(value = emptyList())
)
