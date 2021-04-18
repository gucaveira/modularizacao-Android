package com.gustavo.modularizacaoandroid.features.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.gustavo.modularizacaoandroid.baseviewmodel.BaseViewModel

class MainViewModel : BaseViewModel() {
    val showAndroidJobsLiveData = MutableLiveData<Boolean>()
    val outAppLiveData = MutableLiveData<Boolean>()

    fun onShowAndroidJobsRequire() {
        showAndroidJobsLiveData.postValue(true)
    }

    fun onOutAppLiveData() {
        outAppLiveData.postValue(true)
    }
}