package io.vbytsyuk.example.core.ext

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

suspend fun <T> Flow<T>.collectToLiveData(liveData: MutableLiveData<T>) =
    collect { liveData.value = it }
