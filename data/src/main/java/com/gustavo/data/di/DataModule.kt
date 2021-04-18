package com.gustavo.data.di

import com.gustavo.data.AndroidJobsRepositoryImpl
import com.gustavo.domain.repository.AndroidJobsRepository
import org.koin.dsl.module


val repositoryModule = module {
    factory<AndroidJobsRepository> {
        AndroidJobsRepositoryImpl(
            jobsCacheDataSource = get(),
            remoteDataSource = get()
        )
    }
}

val dataModules = listOf(remoteDataSourceModule, repositoryModule, cacheDataModule)