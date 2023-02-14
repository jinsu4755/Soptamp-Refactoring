package org.sopt.android.remote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.android.remote.api.AuthService
import org.sopt.android.remote.api.MissionsService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RemoteModule {
    @Provides
    @Singleton
    fun provideAuthService(
        retrofit: Retrofit
    ): AuthService = retrofit.create(AuthService::class.java)

    @Provides
    @Singleton
    fun provideMissionsService(
        retrofit: Retrofit
    ): MissionsService = retrofit.create(MissionsService::class.java)
}
