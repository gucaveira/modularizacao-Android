package com.gustavo.data.remote.source

import com.gustavo.data.local.source.JobsCacheDataSource
import com.gustavo.domain.entities.AndroidJob
import com.gustavo.domain.repository.AndroidJobsRepository
import io.reactivex.Single


class AndroidJobsRepositoryImpl(
    private val jobsCacheDataSource: JobsCacheDataSource,
    private val remoteDataSource: RemoteDataSource
) : AndroidJobsRepository {

    override fun getJobs(forceUpdate: Boolean): Single<List<AndroidJob>> {
        return if (forceUpdate)
            getJobsRemote(forceUpdate)
        else {
            jobsCacheDataSource.getJobs()
                .flatMap { listJobs ->
                    when (listJobs.isEmpty()) {
                        true -> getJobsRemote(false)
                        else -> Single.just(listJobs)
                    }
                }
        }
    }


    private fun getJobsRemote(isUpdate: Boolean): Single<List<AndroidJob>> {
        return remoteDataSource.getJobs()
            .flatMap { listJobs ->
                if (isUpdate) {
                    jobsCacheDataSource.updateData(listJobs)
                } else {
                    jobsCacheDataSource.insertData(listJobs)
                }
                Single.just(listJobs)
            }
    }
}