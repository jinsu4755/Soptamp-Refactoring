package org.sopt.android.stamp.di

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.sopt.android.stamp.App
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object FlipperModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideFlipperOkhttpInterceptor(): FlipperOkhttpInterceptor =
        FlipperOkhttpInterceptor(App.networkFlipperPlugin)

    @Provides
    @Singleton
    fun provideOkhttpClient(
        loggingInterceptor: Interceptor,
        flipperOkhttpInterceptor: FlipperOkhttpInterceptor
    ) = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addNetworkInterceptor(flipperOkhttpInterceptor)
        .build()
}
