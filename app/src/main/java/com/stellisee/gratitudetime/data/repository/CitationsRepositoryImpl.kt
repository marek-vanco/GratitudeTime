package com.stellisee.gratitudetime.data.repository

import androidx.lifecycle.LiveData
import com.stellisee.gratitudetime.data.db.CitationDao
import com.stellisee.gratitudetime.data.db.model.Citation

class CitationsRepositoryImpl(private val citationDao: CitationDao) : CitationsRepository {

    init {
            getCitation(1)
    }

    override fun getCitation(id: Int): LiveData<Citation> {
        return citationDao.getCitation(id)
    }
}