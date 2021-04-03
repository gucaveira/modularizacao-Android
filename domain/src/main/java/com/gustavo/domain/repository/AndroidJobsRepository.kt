package com.gustavo.domain.repository

import com.gustavo.domain.entities.AndroidJob
import io.reactivex.Single

interface AndroidJobsRepository {
    fun getJobs(forceUpdate: Boolean): Single<List<AndroidJob>>
}
