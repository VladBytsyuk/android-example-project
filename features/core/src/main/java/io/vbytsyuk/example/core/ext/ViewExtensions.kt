package io.vbytsyuk.example.core.ext

import android.view.View


var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) { visibility = if (value) View.VISIBLE else View.GONE }