package com.stellisee.gratitudetime.ui.citation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.stellisee.gratitudetime.viewmodel.CitationViewModel
import kotlinx.android.synthetic.main.fragment_citation.view.*
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class CitationFragment() : Fragment(), KodeinAware {

    override val kodein by kodein()

    private val citationViewModel by instance<CitationViewModel>()
    // private val citationViewModelFactory : CitationViewModelFactory by instance<CitationViewModelFactory>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = CitationFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = citationViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



    }
}
