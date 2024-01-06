package tech.eightbits.core_network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import tech.eightbits.core.models.DataListResponse
import tech.eightbits.core.models.MovieResponse
import tech.eightbits.core.utils.AppConfig

/**
 * Created by ozan on 5.01.2024
 */

abstract class MovieApi(
    private val appConfig: AppConfig
) {
    @GET("movie/{category}")
    abstract suspend fun getMovieByCategory(
        @Path("category") category: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = appConfig.getConfigValue(AppConfig.API_KEY)
    ): DataListResponse<MovieResponse>

    companion object {
        const val Category_Popular = "popular"
        const val Category_Upcoming = "upcoming"
        const val Category_Now_Playing = "now_playing"
        const val Category_Top_Rated = "top_rated"
    }
}