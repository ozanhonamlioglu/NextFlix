package tech.eightbits.core_ui.extensions

import androidx.navigation.NavHostController
import tech.eightbits.core.utils.NavEvent

/**
 * Created by ozan on 7.01.2024
 */

fun NavHostController.navigate(event: NavEvent) {
    when(event) {
        is NavEvent.Navigate -> {
            if(currentDestination?.route != event.route) {
                navigate(event.route)
            }
        }
    }
}