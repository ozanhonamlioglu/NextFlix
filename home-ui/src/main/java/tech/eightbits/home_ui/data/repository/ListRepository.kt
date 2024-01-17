package tech.eightbits.home_ui.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import tech.eightbits.core.models.DataListResponse
import tech.eightbits.core.models.ErrorResponse
import tech.eightbits.core.models.MovieResponse
import tech.eightbits.core.models.TvShowResponse
import tech.eightbits.core.utils.AppConfig
import tech.eightbits.core_network.MovieApi
import tech.eightbits.core_network.TvShowsApi
import tech.eightbits.core_network.models.UiResponseDto
import javax.inject.Inject

/**
 * Created by ozan on 5.01.2024
 */

class ListRepository @Inject constructor(
    private val movieApi: MovieApi,
    private val tvShowsApi: TvShowsApi,
    private val appConfig: AppConfig
) {

    suspend fun getMovieListByCategory(
        category: String,
        page: Int
    ): Flow<UiResponseDto<DataListResponse<MovieResponse>>> {
        return flow {

            emit(UiResponseDto(isLoading = true))

            val response = movieApi.getMovieByCategory(
                category,
                page,
                appConfig.getConfigValue(AppConfig.API_KEY)
            )

            if (!response.isSuccessful) {
                val errorBody = response.errorBody()?.string()?.let {
                    Json.decodeFromString<ErrorResponse>(it)
                }

                emit(
                    UiResponseDto(
                        data = null,
                        isLoading = false,
                        success = false,
                        statusCode = errorBody?.statusCode,
                        statusMessage = errorBody?.statusMessage
                    )
                )
                return@flow
            }

            emit(
                UiResponseDto(
                    data = response.body(),
                    isLoading = false
                )
            )

        }
    }

    fun getTvShowsByCategory(
        category: String,
        page: Int
    ): Flow<UiResponseDto<DataListResponse<TvShowResponse>>> {
        return flow {

            emit(UiResponseDto(isLoading = true))

            val response = tvShowsApi.getTvShowsByCategory(
                category,
                page,
                appConfig.getConfigValue(AppConfig.API_KEY)
            )

            if (!response.isSuccessful) {
                val errorBody = response.errorBody()?.string()?.let {
                    Json.decodeFromString<ErrorResponse>(it)
                }

                emit(
                    UiResponseDto(
                        data = null,
                        isLoading = false,
                        success = false,
                        statusCode = errorBody?.statusCode,
                        statusMessage = errorBody?.statusMessage
                    )
                )
                return@flow
            }

            emit(
                UiResponseDto(
                    data = response.body(),
                    isLoading = false
                )
            )

        }
    }

}