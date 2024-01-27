package tech.eightbits.home_ui.utils

import tech.eightbits.core.models.MovieResponse

/**
 * Created by ozan on 27.01.2024
 */
fun popularFakeData(id: Int): MovieResponse {
    return MovieResponse(
        adult = false,
        backdrop_path = null,
        genre_ids = listOf(28, 12, 14),
        id = id,
        original_language = "en",
        original_title = "Sample Movie",
        overview = "This is a sample movie overview.",
        popularity = 7.8,
        poster_path = null,
        release_date = "2022-01-15",
        title = "Sample Movie",
        video = false,
        vote_average = 7.5,
        vote_count = 1000,
        isLoading = true // Set to false to indicate that the data is not being loaded
    )
}