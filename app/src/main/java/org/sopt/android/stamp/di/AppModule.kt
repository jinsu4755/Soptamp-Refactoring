package org.sopt.android.stamp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.android.stamp.BuildConfig
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Provides
    @Named("baseUrl")
    fun provideBaseUrl(): String = BuildConfig.SOPTAMP_API_KEY
}
