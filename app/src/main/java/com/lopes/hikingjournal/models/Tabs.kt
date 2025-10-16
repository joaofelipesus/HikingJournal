package com.lopes.hikingjournal.models

import com.lopes.hikingjournal.R
import com.lopes.hikingjournal.activities.baseURL
import dev.hotwire.navigation.navigator.NavigatorConfiguration
import dev.hotwire.navigation.tabs.HotwireBottomTab

private val hikes = HotwireBottomTab(
    title = "Hkes",
    iconResId = android.R.drawable.ic_menu_mapmode,
    configuration = NavigatorConfiguration(
        name = "hikes",
        navigatorHostId = R.id.hikes_nav_host,
        startLocation = "$baseURL/hikes"
    )
)

private val hikers = HotwireBottomTab(
    title = "Hikers",
    iconResId = android.R.drawable.ic_menu_myplaces,
    configuration = NavigatorConfiguration(
        name = "hikers",
        navigatorHostId = R.id.hikers_nav_host,
        startLocation = "$baseURL/users"
    )
)

val mainTabs = listOf(hikes, hikers)