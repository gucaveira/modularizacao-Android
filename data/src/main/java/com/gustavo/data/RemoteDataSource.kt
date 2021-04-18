package com.gustavo.data

import com.gustavo.domain.entities.AndroidJob
import io.reactivex.Single

interface RemoteDataSource {
    fun getJobs(): Single<List<AndroidJob>>
}