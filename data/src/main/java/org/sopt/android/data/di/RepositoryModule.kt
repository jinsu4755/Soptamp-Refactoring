package org.sopt.android.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.android.data.repository.RemoteAuthRepository
import org.sopt.android.domain.repository.AuthRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRemoteAuthRepository(
        repository: RemoteAuthRepository
    ): AuthRepository
}
