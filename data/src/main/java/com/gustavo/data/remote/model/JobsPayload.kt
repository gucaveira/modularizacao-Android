package com.gustavo.data.remote.model

import com.google.gson.annotations.SerializedName

class JobsPayload(
    @SerializedName("jobs")
    val jobsPayload: List<AndroidJobPayload>
)

class AndroidJobPayload(
    @SerializedName("title")
    val title: String,

    @SerializedName("native")
    val native: Boolean,

    @SerializedName("required_experience_years")
    val requiredExperienceYears: Int,

    @SerializedName("country")
    val country: String
)