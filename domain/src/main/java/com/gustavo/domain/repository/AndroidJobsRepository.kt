package com.gustavo.domain.repository

import com.gustavo.domain.entities.AndroidJob
import io.reactivex.Observable

interface AndroidJobsRepository {
    fun getJobs(forceUpdate: Boolean): Observable<List<AndroidJob>>
}
