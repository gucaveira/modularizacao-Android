package com.gustavo.modularizacaoandroid.features.list.viewmodel

import androidx.lifecycle.MutableLiveData
import com.gustavo.domain.entities.AndroidJob
import com.gustavo.domain.usecases.GetJobsUseCases
import com.gustavo.modularizacaoandroid.baseviewmodel.BaseViewModel
import com.gustavo.modularizacaoandroid.baseviewmodel.StateMachineSingle
import com.gustavo.modularizacaoandroid.baseviewmodel.ViewState
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.plusAssign

class AndroidJobListViewModel(
    val useCase: GetJobsUseCases,
    val uiScheduler: Scheduler
) : BaseViewModel() {

    val state = MutableLiveData<ViewState<List<AndroidJob>>>().apply {
        value = ViewState.Loading
    }

    fun getJobs(forceUpdate: Boolean = false) {
        disposables += useCase.execute(forceUpdate = forceUpdate)
            .compose(StateMachineSingle())
            .observeOn(uiScheduler)
            .subscribe(
                {
                    //onSuccess
                    state.postValue(it)
                },
                {
                    //onError
                }
            )
    }

    fun onTryAgainRequired() {
        getJobs(forceUpdate = true)
    }
}