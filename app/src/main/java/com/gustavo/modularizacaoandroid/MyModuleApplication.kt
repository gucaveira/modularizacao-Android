package com.gustavo.modularizacaoandroid

import android.app.Application
import com.gustavo.data.di.dataModules
import com.gustavo.domain.di.domainModule
import com.gustavo.modularizacaoandroid.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyModuleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyModuleApplication)

            modules(domainModule + dataModules + listOf(presentationModule))
        }
    }
}