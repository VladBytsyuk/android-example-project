package io.vbytsyuk.example.core.ext

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

suspend fun <T> Flow<List<T>>.collectListToLiveData(liveData: MutableLiveData<List<T>>) =
    collect { newList ->
        liveData.value = liveData.value?.let { it + newList } ?: newList
    }
