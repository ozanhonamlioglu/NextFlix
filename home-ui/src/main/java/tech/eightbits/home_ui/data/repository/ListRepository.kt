package tech.eightbits.home_ui.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import tech.eightbits.core.models.DataListResponse
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

            val response = try {
                movieApi.getMovieByCategory(category, page, appConfig.getConfigValue(AppConfig.API_KEY))
            } catch (e: HttpException) {
                val errorResponse = e.response() as? DataListResponse<MovieResponse>
                emit(
                    UiResponseDto(
                        isLoading = false,
                        data = errorResponse
                    )
                )
                return@flow
            } catch (e: Exception) {
                emit(
                    UiResponseDto(
                        isLoading = false,
                        data = null,
                        serverError = true
                    )
                )
                return@flow
            }

            emit(
                UiResponseDto(
                    isLoading = false,
                    data = response
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

            val response = try {
                tvShowsApi.getTvShowsByCategory(category, page)
            } catch (e: HttpException) {
                val errorResponse = e.response() as? DataListResponse<TvShowResponse>
                emit(
                    UiResponseDto(
                        isLoading = false,
                        data = errorResponse
                    )
                )
                return@flow
            } catch (e: Exception) {
                emit(
                    UiResponseDto(
                        isLoading = false,
                        data = null,
                        serverError = true
                    )
                )
                return@flow
            }

            emit(
                UiResponseDto(
                    isLoading = false,
                    data = response
                )
            )

        }
    }

}