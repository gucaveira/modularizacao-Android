package com.gustavo.data.remote.source

import com.gustavo.data.remote.api.ServerApi
import com.gustavo.data.remote.mapper.AndroidJobMapper
import com.gustavo.domain.entities.AndroidJob
import io.reactivex.Single

class RemoteDataSourceImpl(private val serverApi: ServerApi) : RemoteDataSource {

    override fun getJobs(): Single<List<AndroidJob>> {
        return serverApi.fetchJobs().map { AndroidJobMapper.map(it) }
    }
}