package tech.eightbits.core.models

/**
 * Created by ozan on 5.01.2024
 */

data class DataListResponse<T>(
    val page: Int,
    val results: List<T>,
    val total_pages: Int,
    val total_results: Int
)
