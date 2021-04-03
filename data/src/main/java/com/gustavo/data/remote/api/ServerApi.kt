package com.gustavo.data.remote.api

import com.gustavo.data.remote.model.JobsPayload
import io.reactivex.Single
import retrofit2.http.GET

interface ServerApi {

    @GET("android-jobs")
    fun fetchJobs(): Single<JobsPayload>
}