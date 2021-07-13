package io.vbytsyuk.example.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.vbytsyuk.example.core.databinding.FragmentListBinding
import io.vbytsyuk.example.core.ext.visible

abstract class ListFragment<T, VM : ListViewModel<T>> : BindingFragment<FragmentListBinding>() {

    abstract val listViewModel: VM

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentListBinding.inflate(inflater, container, attachToParent)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        listViewModel.list.observe(viewLifecycleOwner, ::showList)
        setPullToRefreshListener()
        listViewModel.updateList()
        return root
    }

    private fun showList(list: List<T>) = bind { binding ->
        binding.swipeRefreshLayout.isRefreshing = false
        binding.groupEmpty.visible = list.isEmpty()
        binding.recyclerView.visible = list.isNotEmpty()
    }

    private fun setPullToRefreshListener() = bind { binding ->
        binding.swipeRefreshLayout.setOnRefreshListener(listViewModel::updateList)
    }
}
