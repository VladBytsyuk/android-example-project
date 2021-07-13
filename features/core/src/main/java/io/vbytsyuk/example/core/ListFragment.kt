package io.vbytsyuk.example.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.vbytsyuk.example.core.databinding.FragmentListBinding
import io.vbytsyuk.example.core.ext.collectToLiveData
import io.vbytsyuk.example.core.ext.visible
import io.vbytsyuk.example.core.repository.Repository
import kotlinx.coroutines.launch

open class ListFragment<T> : BindingFragment<FragmentListBinding>() {
    private val listViewModel: ListViewModel<T> by viewModels()

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentListBinding.inflate(inflater, container, attachToParent)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        listViewModel.list.observe(viewLifecycleOwner, ::showList)
        listViewModel.updateList()
        return root
    }

    private fun showList(list: List<T>) = bind { binding ->
        binding.groupEmpty.visible = list.isEmpty()
        binding.recyclerView.visible = list.isNotEmpty()
    }
}

class ListViewModel<T> : ViewModel() {
    private val repository: Repository<List<T>> = MockRepository(value = emptyList())

    private val _list = MutableLiveData<List<T>>().apply {
        value = emptyList()
    }
    val list: LiveData<List<T>> get() = _list

    fun updateList() {
        viewModelScope.launch {
            repository.dataFlow().collectToLiveData(_list)
        }
    }
}
