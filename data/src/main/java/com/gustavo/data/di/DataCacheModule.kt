package com.gustavo.data.di

import com.gustavo.data.local.database.JobsDataBase
import com.gustavo.data.local.source.JobsCacheDataSource
import com.gustavo.data.local.source.JobsCacheSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val cacheDataModule = module {
    single { JobsDataBase.createDataBase(androidContext()) }
    factory<JobsCacheDataSource> { JobsCacheSourceImpl(jobsDao = get()) }
}