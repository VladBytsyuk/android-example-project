package io.vbytsyuk.example.characters.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import io.vbytsyuk.example.characters.databinding.FragmentDetailCharacterBinding
import io.vbytsyuk.example.core.BindingFragment

class CharacterDetailFragment : BindingFragment<FragmentDetailCharacterBinding>() {
    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentDetailCharacterBinding.inflate(inflater, container, attachToParent)
}
