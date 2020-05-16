package com.stellisee.gratitudetime.data.repository

import androidx.lifecycle.LiveData
import com.stellisee.gratitudetime.data.db.model.Citation

interface CitationsRepository {

    suspend fun getCitation(id:Int) : LiveData<Citation>

    suspend fun insertCitation(citation: Citation)
}