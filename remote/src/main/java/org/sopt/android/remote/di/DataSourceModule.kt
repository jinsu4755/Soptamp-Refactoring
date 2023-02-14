package org.sopt.android.remote.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.android.data.source.AuthDataSource
import org.sopt.android.data.source.MissionsDataSource
import org.sopt.android.remote.source.RemoteAuthDataSource
import org.sopt.android.remote.source.RemoteMissionsDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindRemoteAuthDataSource(
        source: RemoteAuthDataSource
    ): AuthDataSource

    @Binds
    @Singleton
    abstract fun bindRemoteMissionsDataSource(
        source: RemoteMissionsDataSource
    ): MissionsDataSource
}
