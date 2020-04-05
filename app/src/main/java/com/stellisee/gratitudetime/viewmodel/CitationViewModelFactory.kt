package com.stellisee.gratitudetime.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stellisee.gratitudetime.data.repository.CitationsRepository

@Suppress("UNCHECKED_CAST")
class CitationViewModelFactory(private val repository: CitationsRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CitationViewModel(repository) as T
    }
}
