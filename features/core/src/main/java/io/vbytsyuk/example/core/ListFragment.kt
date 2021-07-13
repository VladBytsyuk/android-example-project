package io.vbytsyuk.example.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.vbytsyuk.example.core.databinding.FragmentListBinding
import io.vbytsyuk.example.core.ext.visible

abstract class ListFragment<T, VM : ListViewModel<T>> : BindingFragment<FragmentListBinding>() {

    abstract val viewModel: VM

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentListBinding.inflate(inflater, container, attachToParent)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        viewModel.list.observe(viewLifecycleOwner, ::showList)
        viewModel.updateList()
        return root
    }

    private fun showList(list: List<T>) = bind { binding ->
        binding.groupEmpty.visible = list.isEmpty()
        binding.recyclerView.visible = list.isNotEmpty()
    }
}
