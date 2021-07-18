package io.vbytsyuk.example.core.ext

import android.view.View
import androidx.annotation.IdRes
import androidx.navigation.findNavController


var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) { visibility = if (value) View.VISIBLE else View.GONE }

fun View.navigate(@IdRes id: Int) =
    findNavController().navigate(id)

fun View.navigateUp() =
    findNavController().navigateUp()
