package com.lopes.hikingjournal.activities

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import com.lopes.hikingjournal.R
import dev.hotwire.navigation.activities.HotwireActivity
import dev.hotwire.navigation.util.applyDefaultImeWindowInsets
import dev.hotwire.core.config.Hotwire
import dev.hotwire.core.turbo.config.PathConfiguration
import dev.hotwire.navigation.tabs.HotwireBottomNavigationController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lopes.hikingjournal.models.mainTabs
import dev.hotwire.navigation.tabs.navigatorConfigurations

 // const val baseURL = "http://10.0.2.2:3000"

const val baseURL = "http://192.168.0.18:3000"

class MainActivity : HotwireActivity() {
    private lateinit var bottomNavigationController: HotwireBottomNavigationController
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.main).applyDefaultImeWindowInsets()

        // set the navigation configuration
        Hotwire.loadPathConfiguration(
            context = this,
            location = PathConfiguration.Location(
                remoteFileUrl = "$baseURL/configurations/android_v1.json"
            )
        )

        initializeBottomTabs()
    }

    override fun navigatorConfigurations() = mainTabs.navigatorConfigurations

    private fun initializeBottomTabs () {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        bottomNavigationController = HotwireBottomNavigationController(this, bottomNavigationView)
        bottomNavigationController.load(mainTabs, 0)
    }
}