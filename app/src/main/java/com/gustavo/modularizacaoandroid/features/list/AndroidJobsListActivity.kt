package com.gustavo.modularizacaoandroid.features.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gustavo.modularizacaoandroid.R
import com.gustavo.modularizacaoandroid.baseviewmodel.ViewState
import com.gustavo.modularizacaoandroid.databinding.ActivityAndroidJobsListBinding
import com.gustavo.modularizacaoandroid.extension.visible
import com.gustavo.modularizacaoandroid.features.list.adapter.AndroidJobsAdapter
import com.gustavo.modularizacaoandroid.features.list.viewmodel.AndroidJobListViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class AndroidJobsListActivity : AppCompatActivity() {

    private val viewModel: AndroidJobListViewModel by viewModel()
    private val androidJobAdapter: AndroidJobsAdapter by inject()

    private lateinit var binding: ActivityAndroidJobsListBinding

    companion object {
        fun launchIntent(context: Context): Intent {
            return Intent(context, AndroidJobsListActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_android_jobs_list)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupView()

        setupRecyclerView()
        setupViewModel()
    }

    private fun setupView() {
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_material)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupViewModel() {
        viewModel.getJobs()

        viewModel.state.observe(this, Observer { state ->
            when (state) {
                is ViewState.Success -> {
                    androidJobAdapter.jobs = state.data
                    setVisibilities(showList = true)
                }
                is ViewState.Loading -> {
                    setVisibilities(showProgressBar = true)
                }
                is ViewState.Failed -> {
                    setVisibilities(showError = true)
                }
            }
        })
    }


    private fun setupRecyclerView() = with(binding.recyclerView) {
        layoutManager = LinearLayoutManager(context)
        adapter = androidJobAdapter
    }

    private fun setVisibilities(
        showProgressBar: Boolean = false,
        showList: Boolean = false,
        showError: Boolean = false
    ) {
        binding.progressBar.visible(showProgressBar)
        binding.recyclerView.visible(showList)
        binding.btnTryAgain.visible(showError)
    }
}
