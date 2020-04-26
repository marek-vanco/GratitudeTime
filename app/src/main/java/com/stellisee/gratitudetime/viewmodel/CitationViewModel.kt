package com.stellisee.gratitudetime.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stellisee.gratitudetime.data.db.model.Citation
import com.stellisee.gratitudetime.data.repository.CitationsRepository
import kotlinx.coroutines.launch

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
            Log.d(CitationViewModel::class.java.simpleName, "information dans _citation: $_citation")
        }
    }
}
