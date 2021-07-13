package io.vbytsyuk.example.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.vbytsyuk.example.core.domain.Item
import io.vbytsyuk.example.core.ext.collectToLiveData
import io.vbytsyuk.example.core.repository.Repository
import kotlinx.coroutines.launch

abstract class ListViewModel<T : Item>(
    private val repository: Repository<List<T>>
) : ViewModel() {

    private val _list = MutableLiveData<List<T>>().apply {
        value = emptyList()
    }
    val list: LiveData<List<T>> get() = _list

    fun updateList() {
        viewModelScope.launch {
            repository.dataFlow()
                .collectToLiveData(_list)
        }
    }
}
