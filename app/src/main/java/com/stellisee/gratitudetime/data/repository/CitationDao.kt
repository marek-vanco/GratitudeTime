package com.stellisee.gratitudetime.data.repository

import androidx.room.Dao
import androidx.room.Query
import com.stellisee.gratitudetime.data.model.Citation

@Dao
interface CitationDao {

    @Query("SELECT * FROM Citation WHERE id = :id")
    fun getCitation(id:Int) : Citation

    @Query("SELECT * FROM Citation")
    fun getAllCitations(): List<Citation>
}
