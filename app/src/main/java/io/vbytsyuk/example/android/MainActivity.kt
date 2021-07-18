package io.vbytsyuk.example.android

import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import io.vbytsyuk.example.android.databinding.ActivityMainBinding

class MainActivity : BindingActivity<ActivityMainBinding>() {
    private var _navController: NavController? = null
    val navController: NavController get() = checkNotNull(_navController) {
        "NavController does not initialized."
    }

    override fun inflateBinding(inflater: LayoutInflater) =
        ActivityMainBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind { binding ->
            setContentView(binding.root)

            val navView: BottomNavigationView = binding.navView

            _navController = findNavController(R.id.nav_host_fragment_activity_main)
            val appBarConfiguration = AppBarConfiguration(
                setOf(R.id.navigation_locations, R.id.navigation_characters, R.id.navigation_episodes)
            )
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return super.onSupportNavigateUp()
    }
}
