package tech.eightbits.core_network.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.eightbits.core_network.Constants
import tech.eightbits.core_network.MovieApi
import tech.eightbits.core_network.TvShowsApi
import javax.inject.Singleton

/**
 * Created by ozan on 5.01.2024
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Singleton
    @Provides
    fun providesMovieApi(): MovieApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .client(client)
        .build()
        .create(MovieApi::class.java)

    @Singleton
    @Provides
    fun providesTvShowsApi(): TvShowsApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .client(client)
        .build()
        .create(TvShowsApi::class.java)

}