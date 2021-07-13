package io.vbytsyuk.example.characters

import io.vbytsyuk.example.core.ListViewModel
import io.vbytsyuk.example.core.domain.Character
import io.vbytsyuk.example.core.repository.Repository

class CharactersListViewModel(repository: Repository<List<Character>>) : ListViewModel<Character>(repository)
