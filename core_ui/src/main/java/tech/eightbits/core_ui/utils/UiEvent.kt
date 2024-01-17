package tech.eightbits.core_ui.utils

/**
 * Created by ozan on 16.01.2024
 */
sealed class UiEvent {
    data class MovieFetch(val category: String, val initial: Boolean) : UiEvent()
    data class TvShowFetch(val category: String) : UiEvent()
}