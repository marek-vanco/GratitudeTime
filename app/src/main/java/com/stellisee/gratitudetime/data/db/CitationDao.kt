package com.stellisee.gratitudetime.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.stellisee.gratitudetime.data.db.model.Citation

@Dao
interface CitationDao {

    @Query("SELECT * FROM Citation WHERE id = :id")
    fun getCitation(id:Int) : LiveData<Citation>

    @Query("SELECT * FROM Citation")
    fun getAllCitations(): LiveData<List<Citation>>
}
