package com.stellisee.gratitudetime.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stellisee.gratitudetime.data.model.Citation
import com.stellisee.gratitudetime.data.repository.CitationsRepository

class CitationViewModel(private val repository: CitationsRepository) : ViewModel() {

    private val _citation = MutableLiveData<Citation>()
    val citation : LiveData<Citation>
        get() = _citation

    fun getCitation() {
        val  citation = repository.getCitation(1)
        _citation.value = citation
    }
}
