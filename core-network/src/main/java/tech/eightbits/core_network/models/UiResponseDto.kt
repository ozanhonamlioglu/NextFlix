package tech.eightbits.core_network.models

/**
 * Created by ozan on 9.01.2024
 */
data class UiResponseDto<T>(
    val data: T? = null,
    val isLoading: Boolean,
    val serverError: Boolean = false
)
