package io.vbytsyuk.example.core

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.viewbinding.ViewBinding
import io.vbytsyuk.example.core.ext.navigateUp

abstract class DetailFragment<VB : ViewBinding> : BindingFragment<VB>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                view?.navigateUp()
            }
        })
    }
}
