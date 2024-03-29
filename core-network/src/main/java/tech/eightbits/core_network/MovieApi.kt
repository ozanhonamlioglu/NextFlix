package tech.eightbits.core_network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import tech.eightbits.core.models.DataListResponse
import tech.eightbits.core.models.MovieResponse

/**
 * Created by ozan on 5.01.2024
 */

interface MovieApi {

    @GET("movie/{category}")
    suspend fun getMovieByCategory(
        @Path("category") category: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String
    ): Response<DataListResponse<MovieResponse>>

    suspend fun getMovieById(): MovieResponse

    companion object {
        const val Category_Popular = "popular"
        const val Category_Upcoming = "upcoming"
        const val Category_Now_Playing = "now_playing"
        const val Category_Top_Rated = "top_rated"
    }
}