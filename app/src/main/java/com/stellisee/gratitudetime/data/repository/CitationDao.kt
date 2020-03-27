package com.stellisee.gratitudetime.data.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.stellisee.gratitudetime.data.model.Citation

@Dao
interface CitationDao {

    @Query("SELECT * FROM Citation WHERE id = :id")
    fun getCitation(id:Int) : Citation

    @Insert
    fun insertCitation(citations: List<Citation>)

}
