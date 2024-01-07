package tech.eightbits.core.utils

/**
 * Created by ozan on 7.01.2024
 */
sealed class NavEvent {
    data class Navigate(val route: String): NavEvent()
}