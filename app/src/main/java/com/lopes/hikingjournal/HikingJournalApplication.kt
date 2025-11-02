package com.lopes.hikingjournal

import android.app.Application
import com.lopes.hikingjournal.activities.baseURL
import dev.hotwire.core.config.Hotwire
import dev.hotwire.core.turbo.config.PathConfiguration
import com.lopes.hikingjournal.fragments.MapFragment
import dev.hotwire.navigation.config.registerFragmentDestinations
import dev.hotwire.navigation.fragments.HotwireWebFragment
import com.lopes.hikingjournal.components.ButtonComponent
import dev.hotwire.core.bridge.BridgeComponentFactory
import dev.hotwire.core.bridge.KotlinXJsonConverter
import dev.hotwire.navigation.config.registerBridgeComponents

class HikingJournalApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // config hotwire navigation
        Hotwire.loadPathConfiguration(
            context = this,
            location = PathConfiguration.Location(
                remoteFileUrl = "$baseURL/configurations/android_v1.json"
            )
        )

        // map fragments
        Hotwire.registerFragmentDestinations(
            HotwireWebFragment::class,
            MapFragment::class
        )

        // map bridge components
        Hotwire.registerBridgeComponents(
            BridgeComponentFactory("button", ::ButtonComponent)
        )

        // configure JSON parser
        Hotwire.config.jsonConverter = KotlinXJsonConverter()
    }
}