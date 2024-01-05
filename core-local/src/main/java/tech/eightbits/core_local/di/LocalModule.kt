package tech.eightbits.core_local.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.eightbits.core_local.mylist_movie.MyListMovieDatabase
import tech.eightbits.core_local.mylist_tvshows.MyListTvShowsDatabase
import javax.inject.Singleton

/**
 * Created by ozan on 5.01.2024
 */

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun providesMyListMovieDatabase(app: Application): MyListMovieDatabase = Room.databaseBuilder(
        app,
        MyListMovieDatabase::class.java,
        "mylistmovie.db"
    ).build()

    @Provides
    @Singleton
    fun providesMyListTvShowsDatabase(app: Application): MyListTvShowsDatabase =
        Room.databaseBuilder(
            app,
            MyListTvShowsDatabase::class.java,
            "mylisttvshows.db"
        ).build()

}