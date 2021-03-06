package io.vbytsyuk.example.core.ext

import android.view.View
import androidx.annotation.IdRes
import androidx.navigation.NavDirections
import androidx.navigation.findNavController


var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) { visibility = if (value) View.VISIBLE else View.GONE }

fun View.navigate(directions: NavDirections) =
    findNavController().navigate(directions)

fun View.navigateUp() =
    findNavController().navigateUp()
