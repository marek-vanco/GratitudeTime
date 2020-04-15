package com.stellisee.gratitudetime.data.repository

import androidx.lifecycle.LiveData
import com.stellisee.gratitudetime.data.db.CitationDao
import com.stellisee.gratitudetime.data.db.model.Citation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CitationsRepositoryImpl(private val citationDao: CitationDao) : CitationsRepository {

    init {
        GlobalScope.launch(Dispatchers.IO) {
            getCitation(1)
        }
    }

    override suspend fun getCitation(id: Int): LiveData<Citation> {
        return withContext(Dispatchers.IO) {
            return@withContext citationDao.getCitation(id)
        }
    }

    companion object {
        @Volatile private var instance: CitationsRepositoryImpl? = null

        fun getInstance(citationDao: CitationDao) =
            instance ?: synchronized(this) {
                instance ?: CitationsRepositoryImpl(citationDao).also { instance = it }
            }
    }


}