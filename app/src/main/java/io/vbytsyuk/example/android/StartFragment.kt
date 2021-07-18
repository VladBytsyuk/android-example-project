package io.vbytsyuk.example.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import io.vbytsyuk.example.android.databinding.FragmentStartBinding
import io.vbytsyuk.example.core.BindingFragment

class StartFragment : BindingFragment<FragmentStartBinding>() {
    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentStartBinding.inflate(inflater, container, attachToParent)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            (activity as MainActivity).navController
                .navigate(R.id.action_navigation_start_to_locations)
        }
    }
}
