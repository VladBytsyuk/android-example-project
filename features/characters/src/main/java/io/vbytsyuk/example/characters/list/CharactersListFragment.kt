package io.vbytsyuk.example.characters.list

import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import io.vbytsyuk.example.characters.R
import io.vbytsyuk.example.core.ListAdapter
import io.vbytsyuk.example.core.ListFragment
import io.vbytsyuk.example.core.domain.Character
import io.vbytsyuk.example.core.ext.navigate
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersListFragment : ListFragment<Character, CharactersListViewModel>() {

    override val listViewModel: CharactersListViewModel by viewModel()

    override val adapterParams = ListAdapter.Params<Character>(
        layoutId = R.layout.adapter_item_character
    ) { character, view ->
        view.findViewById<TextView>(R.id.tvName).text = character.name
        view.findViewById<TextView>(R.id.tvSpecies).text = character.species
        view.findViewById<TextView>(R.id.tvStatus).text = character.status
        view.findViewById<TextView>(R.id.tvGender).text = character.gender
        view.findViewById<ImageView>(R.id.ivAvatar).also { img ->
            Glide.with(this)
                .load(character.imageUrl)
                .circleCrop()
                .placeholder(R.drawable.ic_baseline_person_24)
                .error(R.drawable.ic_baseline_person_24)
                .into(img)
        }
        view.setOnClickListener {
            val action = CharactersListFragmentDirections.actionNavigationCharactersToNavigationCharacterDetail(
                name = character.name,
                species = character.species,
                status = character.status,
                gender = character.gender,
                location = character.locationName,
                imageUrl = character.imageUrl
            )
            view.navigate(action)
        }
    }
}
