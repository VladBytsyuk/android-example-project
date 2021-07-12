package io.vbytsyuk.example.android

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BindingActivity<VB : ViewBinding> : AppCompatActivity() {
    private var _binding: VB? = null

    abstract fun inflateBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflateBinding(layoutInflater)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    fun bind(block: (VB) -> Unit) {
        _binding?.let { block(it) }
            ?: Log.e("Binding", "Try to use ViewBinding when view [${this.javaClass.simpleName}] does not exist.")
    }
}
