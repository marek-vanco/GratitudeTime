package com.stellisee.gratitudetime.data.repository

class CitationsRepository
     private constructor(private val citationDao: CitationDao) {

    fun getCitation(id : Int) = citationDao.selectCitation(id)

    companion object {
        @Volatile private var instance: CitationsRepository? = null

        fun getInstance(citationDao: CitationDao) =
            instance ?: synchronized(this) {
                instance ?: CitationsRepository(citationDao).also { instance = it }
            }
    }
}