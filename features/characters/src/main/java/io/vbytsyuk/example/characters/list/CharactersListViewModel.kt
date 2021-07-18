package io.vbytsyuk.example.characters.list

import io.vbytsyuk.example.core.ListViewModel
import io.vbytsyuk.example.core.domain.Character
import io.vbytsyuk.example.core.repository.Repository

class CharactersListViewModel(repository: Repository<Character>) : ListViewModel<Character>(repository)
