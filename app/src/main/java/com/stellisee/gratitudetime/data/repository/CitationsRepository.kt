package com.stellisee.gratitudetime.data.repository

import androidx.lifecycle.LiveData
import com.stellisee.gratitudetime.data.db.model.Citation

interface CitationsRepository {

    fun getCitation(id:Int) : LiveData<Citation>
}