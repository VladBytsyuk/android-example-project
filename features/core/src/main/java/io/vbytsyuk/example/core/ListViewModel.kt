package io.vbytsyuk.example.core

import androidx.lifecycle.*
import io.vbytsyuk.example.core.domain.Item
import io.vbytsyuk.example.core.ext.collectListToLiveData
import io.vbytsyuk.example.core.repository.Repository
import kotlinx.coroutines.launch

abstract class ListViewModel<T : Item>(
    private val repository: Repository<T>
) : ViewModel() {

    private val _list = MutableLiveData<List<T>>().apply {
        value = emptyList()
    }
    val list: LiveData<List<T>> get() = _list

    fun updateList() {
        viewModelScope.launch {
            repository.dataFlow()
                .collectListToLiveData(_list)
        }
    }

    fun reloadList() {
        _list.value = emptyList()
        repository.clearState()
        viewModelScope.launch {
            repository.dataFlow()
                .collectListToLiveData(_list)
        }
    }
}
