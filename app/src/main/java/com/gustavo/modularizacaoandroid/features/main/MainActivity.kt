package com.gustavo.modularizacaoandroid.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.gustavo.modularizacaoandroid.R
import com.gustavo.modularizacaoandroid.databinding.ActivityMainBinding
import com.gustavo.modularizacaoandroid.features.list.AndroidJobsListActivity
import com.gustavo.modularizacaoandroid.features.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.showAndroidJobsLiveData.observe(this, Observer { isShow ->
            when (isShow) {
                true -> {
                    startActivity(AndroidJobsListActivity.launchIntent(this))
                }
            }
        })

        viewModel.outAppLiveData.observe(this, Observer { isOut ->
            when (isOut) {
                true -> {
                    finish()
                }
            }
        })
    }
}