package io.vbytsyuk.example.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import io.vbytsyuk.example.core.databinding.FragmentListBinding
import io.vbytsyuk.example.core.domain.Item
import io.vbytsyuk.example.core.ext.visible

abstract class ListFragment<T : Item, VM : ListViewModel<T>> : BindingFragment<FragmentListBinding>() {

    abstract val listViewModel: VM
    abstract val adapterParams: ListAdapter.Params<T>

    private val listAdapter: ListAdapter<T> by lazy { ListAdapter(adapterParams) }

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentListBinding.inflate(inflater, container, attachToParent)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        setRecyclerView()
        listViewModel.list.observe(viewLifecycleOwner, ::showList)
        setPullToRefreshListener()
        listViewModel.updateList()
        return root
    }

    private fun setRecyclerView() = bind { binding ->
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = listAdapter
    }

    private fun showList(list: List<T>) = bind { binding ->
        binding.swipeRefreshLayout.isRefreshing = false
        binding.groupEmpty.visible = list.isEmpty()
        binding.recyclerView.visible = list.isNotEmpty()
        listAdapter.submitList(list)
    }

    private fun setPullToRefreshListener() = bind { binding ->
        binding.swipeRefreshLayout.setOnRefreshListener(listViewModel::updateList)
    }
}
