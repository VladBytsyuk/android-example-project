package io.vbytsyuk.example.android.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import io.vbytsyuk.example.android.databinding.FragmentDashboardBinding
import io.vbytsyuk.example.android.ui.BindingFragment

class DashboardFragment : BindingFragment<FragmentDashboardBinding>() {

    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?, attachToParent: Boolean) =
        FragmentDashboardBinding.inflate(inflater, container, attachToParent)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        bind { binding ->
            val textView: TextView = binding.textDashboard
            dashboardViewModel.text.observe(viewLifecycleOwner, { textView.text = it })
        }
        return root
    }
}
