package com.lopes.hikingjournal.components

import dev.hotwire.core.bridge.BridgeComponent
import dev.hotwire.core.bridge.BridgeDelegate
import dev.hotwire.navigation.destinations.HotwireDestination
import dev.hotwire.core.bridge.Message
import dev.hotwire.navigation.fragments.HotwireFragment
import androidx.compose.material3.Text
import androidx.compose.ui.platform.ComposeView
import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.compose.material3.Button

class ButtonComponent(
    name: String,
    private val bridgeDelegate: BridgeDelegate<HotwireDestination>
) : BridgeComponent<HotwireDestination>(name, bridgeDelegate) {
    private val buttonId = 1
    private val fragment: HotwireFragment
      get() = bridgeDelegate.destination.fragment as HotwireFragment


    override fun onReceive(message: Message) {
        if (message.event == "connect") {
            removeButton()
            addButton(message)
        } else if (message.event == "disconnect") {
            removeButton()
        }
    }

    private fun addButton (message: Message) {
        val composeView = ComposeView(fragment.requireContext()).apply {
            id = buttonId
            setContent {
                Button(
                    onClick = { replyTo(message.event) }
                ) {
                    Text("Sign in")
                }
            }
        }

        val layoutParams = Toolbar.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ).apply { gravity = Gravity.END }

        val toolbar = fragment.toolbarForNavigation()
        toolbar?.addView(composeView, layoutParams)
    }

    private fun removeButton() {
        val toolbar = fragment.toolbarForNavigation()
        val button = toolbar?.findViewById<ComposeView>(buttonId)
        toolbar?.removeView(button)
    }
}