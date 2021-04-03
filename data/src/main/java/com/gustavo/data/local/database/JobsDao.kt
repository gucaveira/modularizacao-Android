package com.gustavo.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.gustavo.data.local.model.AndroidJobCache
import io.reactivex.Single

@Dao
interface JobsDao {

    @Query("SELECT * FROM jobs")
    fun getJobs(): Single<List<AndroidJobCache>>

    @Transaction
    fun updateData(users: List<AndroidJobCache>) {
        deleteAllUsers()
        insertAll(users)
    }

    @Insert
    fun insertAll(users: List<AndroidJobCache>)

    @Query("DELETE FROM jobs")
    fun deleteAllUsers()

}