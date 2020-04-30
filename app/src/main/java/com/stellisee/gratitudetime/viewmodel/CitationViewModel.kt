package com.stellisee.gratitudetime.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stellisee.gratitudetime.data.db.model.Citation
import com.stellisee.gratitudetime.data.repository.CitationsRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class CitationViewModel(private val repository: CitationsRepository) : ViewModel() {

    private val _citation = MutableLiveData<Citation>()

    val citation : LiveData<Citation>
        get() = _citation

    init {
        fetchCitation()
    }

    fun fetchCitation() {
        viewModelScope.launch() {
            val cit = repository.getCitation(1)
            _citation.value = cit.value
//            val cit = Citation("ph2", "au2")
//            _citation.value = cit
            Timber.d("citation ${citation.value} dans _citation: ${_citation.value} and ${cit.value}")
        }
    }
}
