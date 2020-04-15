package com.stellisee.gratitudetime.viewmodel

import androidx.lifecycle.ViewModel
import com.stellisee.gratitudetime.data.repository.CitationsRepository

class CitationViewModel(private val citationsRepository: CitationsRepository) : ViewModel() {

    fun getCitation() = citationsRepository.getCitation(1)

}
