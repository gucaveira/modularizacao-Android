package com.gustavo.data.remote.mapper

import com.gustavo.data.remote.model.AndroidJobPayload
import com.gustavo.data.remote.model.JobsPayload
import com.gustavo.domain.entities.AndroidJob

object AndroidJobMapper {

    fun map(payload: JobsPayload) = payload.jobsPayload.map { map(it) }

    private fun map(payload: AndroidJobPayload) = AndroidJob(
        title = payload.title,
        native = payload.native,
        experienceTimeRequired = payload.requiredExperienceYears,
        country = payload.country
    )
}