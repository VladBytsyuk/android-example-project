package io.vbytsyuk.example.android.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BindingFragment<VB : ViewBinding> : Fragment() {
    private var _binding: VB? = null

    abstract fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean = false): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = inflateBinding(inflater, container, attachToParent = false)
        _binding = binding
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun bind(block: (VB) -> Unit) {
        _binding?.let { block(it) }
            ?: Log.e("Binding", "Try to use ViewBinding when view [${this.javaClass.simpleName}] does not exist.")
    }
}
