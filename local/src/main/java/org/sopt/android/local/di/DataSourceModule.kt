package org.sopt.android.local.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.android.data.source.UserDataSource
import org.sopt.android.local.source.LocalUserDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindLocalDataSourceModule(
        source: LocalUserDataSource
    ): UserDataSource
}
