package tech.eightbits.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tech.eightbits.core.utils.AppConfig
import javax.inject.Singleton

/**
 * Created by ozan on 6.01.2024
 */

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Singleton
    @Provides
    fun providesAppConfig(@ApplicationContext context: Context) = AppConfig(context)

}