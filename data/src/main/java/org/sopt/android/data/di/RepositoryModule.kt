package org.sopt.android.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.android.data.repository.LocalUserRepository
import org.sopt.android.data.repository.RemoteAuthRepository
import org.sopt.android.data.repository.RemoteMissionsRepository
import org.sopt.android.domain.repository.AuthRepository
import org.sopt.android.domain.repository.MissionsRepository
import org.sopt.android.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRemoteAuthRepository(
        repository: RemoteAuthRepository
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindLocalUserRepository(
        repository: LocalUserRepository
    ): UserRepository

    @Binds
    @Singleton
    abstract fun bindRemoteMissionsRepository(
        repository: RemoteMissionsRepository
    ): MissionsRepository
}
