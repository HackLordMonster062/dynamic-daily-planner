package org.hacklord.dynamic_planner

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "DynamicPlanner",
    ) {
        App()
    }
}