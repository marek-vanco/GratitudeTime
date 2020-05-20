package com.stellisee.gratitudetime.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stellisee.gratitudetime.data.db.model.Citation
import com.stellisee.gratitudetime.data.repository.CitationsRepository
import timber.log.Timber

class CitationViewModel(private val repository: CitationsRepository) : ViewModel() {

    private var i = 0
    private val _citation = MutableLiveData<Citation>()

    val citation : LiveData<Citation>
        get() = _citation

    init {
        fetchCitation()
    }

    fun fetchCitation() {
             var cit = repository.getCitation(5)
//           val cit2 = Citation("ph2", "au2", 1)
//           _citation.value = cit2
        Timber.d("citation ${citation.value} dans _citation: ${_citation.value} and ${cit.value}")
        _citation.value = cit.value
    }
}
