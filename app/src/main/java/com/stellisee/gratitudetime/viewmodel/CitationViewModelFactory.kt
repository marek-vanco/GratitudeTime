package com.stellisee.gratitudetime.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stellisee.gratitudetime.data.repository.CitationsRepository

class CitationViewModelFactory(private val citationsRepository: CitationsRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CitationViewModel(citationsRepository) as T
    }
}
