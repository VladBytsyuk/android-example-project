package io.vbytsyuk.example.android.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import io.vbytsyuk.example.android.databinding.FragmentCharactersBinding
import io.vbytsyuk.example.android.ui.BindingFragment

class CharactersFragment : BindingFragment<FragmentCharactersBinding>() {

    private val charactersViewModel: CharactersViewModel by viewModels()

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentCharactersBinding.inflate(inflater, container, attachToParent)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        bind { binding ->
            val textView: TextView = binding.textCharacters
            charactersViewModel.text.observe(viewLifecycleOwner, { textView.text = it })
        }
        return root
    }
}