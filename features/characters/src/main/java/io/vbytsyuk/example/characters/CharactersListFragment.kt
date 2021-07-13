package io.vbytsyuk.example.characters

import androidx.fragment.app.viewModels
import io.vbytsyuk.example.core.ListFragment
import io.vbytsyuk.example.core.domain.Character

class CharactersListFragment : ListFragment<Character, CharactersListViewModel>() {

    override val listViewModel: CharactersListViewModel by viewModels()

}
