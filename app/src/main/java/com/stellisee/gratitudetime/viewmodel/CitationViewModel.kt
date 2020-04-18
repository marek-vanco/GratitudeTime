package com.stellisee.gratitudetime.viewmodel

import androidx.lifecycle.ViewModel
import com.stellisee.gratitudetime.data.repository.CitationsRepository
import com.stellisee.gratitudetime.internal.lazyDeferred

class CitationViewModel(private val citationsRepository: CitationsRepository) : ViewModel() {

    val citation by lazyDeferred {
          citationsRepository.getCitation(1)
    }

}
