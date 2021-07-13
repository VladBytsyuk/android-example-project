package io.vbytsyuk.example.characters

import android.widget.TextView
import io.vbytsyuk.example.core.ListAdapter
import io.vbytsyuk.example.core.ListFragment
import io.vbytsyuk.example.core.domain.Character
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersListFragment : ListFragment<Character, CharactersListViewModel>() {

    override val listViewModel: CharactersListViewModel by viewModel()

    override val adapterParams = ListAdapter.Params<Character>(layoutId = R.layout.adapter_item_character) { character, view ->
        view.findViewById<TextView>(R.id.tvName).text = character.name
        view.findViewById<TextView>(R.id.tvSpecies).text = character.species
        view.findViewById<TextView>(R.id.tvStatus).text = character.status
        view.findViewById<TextView>(R.id.tvGender).text = character.gender
    }
}
