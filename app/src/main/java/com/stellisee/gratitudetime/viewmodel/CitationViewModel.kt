package com.stellisee.gratitudetime.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stellisee.gratitudetime.data.db.model.Citation
import com.stellisee.gratitudetime.data.repository.CitationsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

class CitationViewModel(private val repository: CitationsRepository) : ViewModel() {

    private var i = 0
    private val _citation = MutableLiveData<Citation>()

    val citation : LiveData<Citation>
        get() = _citation

    init {
        //insertCitation()
        fetchCitation()
    }

    fun fetchCitation() {
        val job = GlobalScope.launch(Dispatchers.IO) {
             var cit = repository.getCitation(5)
//           val cit2 = Citation("ph2", "au2", 1)
//           _citation.value = cit2
        Timber.d("citation ${citation.value} dans _citation: ${_citation.value} and ${cit.value}")
        _citation.value = cit.value
        }
    }

    fun insertCitation() {
        GlobalScope.launch(Dispatchers.IO) {
            for(a in 0..1000) {
                i++
                repository.insertCitation(Citation("ph1 ${i}", "au1"))
                Timber.d("insert new entry to database ${i}")
            }
        }
    }
}
