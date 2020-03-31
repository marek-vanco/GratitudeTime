package com.stellisee.gratitudetime.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stellisee.gratitudetime.data.model.Citation
import com.stellisee.gratitudetime.data.repository.CitationDao

class CitationViewModel(private val citationDao: CitationDao) : ViewModel() {

    private val citationLiveData : MutableLiveData<Citation> by lazy {
        MutableLiveData<Citation>()
    }


    private fun loadCitation(id:Int) {
        var cit = citationDao.selectCitation(id)
        citationLiveData.value = cit
    }

}