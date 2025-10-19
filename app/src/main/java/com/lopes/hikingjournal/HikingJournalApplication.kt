package com.lopes.hikingjournal

import android.app.Application
import com.lopes.hikingjournal.activities.baseURL
import dev.hotwire.core.config.Hotwire
import dev.hotwire.core.turbo.config.PathConfiguration

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
    }
}