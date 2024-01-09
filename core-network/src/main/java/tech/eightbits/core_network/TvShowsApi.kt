package tech.eightbits.core_network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import tech.eightbits.core.models.DataListResponse
import tech.eightbits.core.models.TvShowResponse
import tech.eightbits.core.utils.AppConfig

/**
 * Created by ozan on 6.01.2024
 */
interface TvShowsApi {
    val appConfig: AppConfig

    @GET("tv/{category}")
    suspend fun getTvShowsByCategory(
        @Path("category") category: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = appConfig.getConfigValue(AppConfig.API_KEY)
    ): DataListResponse<TvShowResponse>

    suspend fun getTvShowById(): TvShowResponse

    companion object {
        const val Category_Airing_Today = "airing_today"
        const val Category_On_The_Air = "on_the_air"
        const val Category_Popular = "popular"
        const val Category_Top_Rated = "top_rated"
    }
}