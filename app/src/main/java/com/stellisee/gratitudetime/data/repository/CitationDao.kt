package com.stellisee.gratitudetime.data.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.stellisee.gratitudetime.data.model.Citation

@Dao
interface CitationDao {

    @Query("SELECT * FROM Citation WHERE id = :id")
    fun selectCitation(id:Int) : Citation

    @Insert(onConflict = REPLACE)
    fun insertCitation(citation: Citation)

    @Insert(onConflict = REPLACE)
    fun insertAllCitations(listCitation: List<Citation>)
}
