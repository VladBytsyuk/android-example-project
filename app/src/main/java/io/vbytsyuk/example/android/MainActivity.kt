package io.vbytsyuk.example.android

import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import io.vbytsyuk.example.android.databinding.ActivityMainBinding

class MainActivity : BindingActivity<ActivityMainBinding>() {

    override fun inflateBinding(inflater: LayoutInflater) = ActivityMainBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind { binding ->
            setContentView(binding.root)

            val navView: BottomNavigationView = binding.navView

            val navController = findNavController(R.id.nav_host_fragment_activity_main)
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
                )
            )
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)
        }
    }
}
