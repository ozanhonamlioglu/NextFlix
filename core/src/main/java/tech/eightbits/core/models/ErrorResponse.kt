package tech.eightbits.core.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

/**
 * Created by ozan on 14.01.2024
 */

@Serializable
data class ErrorResponse(
    val success: Boolean,

    @SerialName("status_code")
    val statusCode: Int,

    @SerialName("status_message")
    val statusMessage: String
)
