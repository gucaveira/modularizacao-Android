package com.gustavo.modularizacaoandroid.di

import com.gustavo.modularizacaoandroid.features.list.adapter.AndroidJobsAdapter
import com.gustavo.modularizacaoandroid.features.list.viewmodel.AndroidJobListViewModel
import com.gustavo.modularizacaoandroid.features.main.viewmodel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    factory { AndroidJobsAdapter() }

    viewModel { MainViewModel() }

    viewModel {
        AndroidJobListViewModel(
            useCase = get(),
            uiScheduler = AndroidSchedulers.mainThread()
        )
    }
}