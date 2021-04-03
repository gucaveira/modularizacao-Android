package com.gustavo.data.local.source

import com.gustavo.domain.entities.AndroidJob
import io.reactivex.Single

interface JobsCacheDataSource {
    fun getJobs(): Single<List<AndroidJob>>
    fun insertData(list: List<AndroidJob>)
    fun updateData(list: List<AndroidJob>)

}