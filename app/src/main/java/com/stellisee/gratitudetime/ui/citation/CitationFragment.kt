package com.stellisee.gratitudetime.ui.citation

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.stellisee.gratitudetime.R
import com.stellisee.gratitudetime.databinding.FragmentCitationBinding
import com.stellisee.gratitudetime.viewmodel.CitationViewModel
import com.stellisee.gratitudetime.viewmodel.CitationViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class CitationFragment() : Fragment(), KodeinAware {

    override val kodein by closestKodein()
    private val citationViewModelFactory by instance<CitationViewModelFactory>()
    private lateinit var binding : FragmentCitationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // databinding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_citation, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val citationViewModel = citationViewModelFactory.create(CitationViewModel::class.java)
        binding.viewmodel = citationViewModel
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        binding.viewmodel?.fetchCitation()
    }
}
