package io.vbytsyuk.example.characters.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import io.vbytsyuk.example.characters.R
import io.vbytsyuk.example.characters.databinding.FragmentDetailCharacterBinding
import io.vbytsyuk.example.core.ext.DetailFragment

class CharacterDetailFragment : DetailFragment<FragmentDetailCharacterBinding>() {
    private val args: CharacterDetailFragmentArgs by navArgs()

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentDetailCharacterBinding.inflate(inflater, container, attachToParent)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind { binding ->
            binding.tvName.text = args.name
            binding.tvSpecies.text = args.species
            binding.tvStatus.text = args.status
            binding.tvGender.text = args.gender
            binding.tvLocation.text = args.location
            Glide.with(this)
                .load(args.imageUrl)
                .circleCrop()
                .placeholder(R.drawable.ic_baseline_person_24)
                .error(R.drawable.ic_baseline_person_24)
                .into(binding.ivAvatar)
        }
    }
}
