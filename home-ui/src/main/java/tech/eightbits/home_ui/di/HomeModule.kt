package tech.eightbits.home_ui.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.eightbits.core.utils.AppConfig
import tech.eightbits.core_network.MovieApi
import tech.eightbits.core_network.TvShowsApi
import tech.eightbits.home_ui.data.repository.ListRepository
import javax.inject.Singleton

/**
 * Created by ozan on 9.01.2024
 */

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides
    @Singleton
    fun providesListRepository(
        movieApi: MovieApi,
        tvShowsApi: TvShowsApi,
        appConfig: AppConfig
    ) = ListRepository(movieApi, tvShowsApi, appConfig)

}