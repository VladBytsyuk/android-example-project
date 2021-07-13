package io.vbytsyuk.example.characters

import androidx.fragment.app.viewModels
import io.vbytsyuk.example.core.ListFragment
import io.vbytsyuk.example.core.domain.Character

class CharactersFragment : ListFragment<Character, CharactersViewModel>() {

    override val viewModel: CharactersViewModel by viewModels()

}
