package com.gustavo.data.di

import com.gustavo.data.remote.source.RemoteDataSource
import com.gustavo.data.remote.source.RemoteDataSourceImpl
import org.koin.dsl.module.module


val repositoryModule = module {
    factory<RemoteDataSource> { RemoteDataSourceImpl(serverApi = get()) }
}

val dataModules = listOf(remoteDataSourceModule, repositoryModule, cacheDataModule)