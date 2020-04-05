package com.stellisee.gratitudetime.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stellisee.gratitudetime.R
import com.stellisee.gratitudetime.data.repository.CitationsRepository
import com.stellisee.gratitudetime.viewmodel.CitationViewModel
import com.stellisee.gratitudetime.viewmodel.CitationViewModelFactory
import kotlinx.android.synthetic.main.fragment_citation.*

class CitationFragment() : Fragment() {

    private lateinit var factory : CitationViewModelFactory
    private val citationViewModel : CitationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_citation, container, false);
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        citationViewModel.citation.observe(viewLifecycleOwner, Observer {
            textView_citation
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CitationFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
