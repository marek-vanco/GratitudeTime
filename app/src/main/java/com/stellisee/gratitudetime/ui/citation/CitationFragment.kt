package com.stellisee.gratitudetime.ui.citation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.stellisee.gratitudetime.databinding.FragmentCitationBinding
import com.stellisee.gratitudetime.viewmodel.CitationViewModel
import com.stellisee.gratitudetime.viewmodel.CitationViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class CitationFragment() : Fragment(), KodeinAware {

    override val kodein by closestKodein()
    private val citationViewModelFactory by instance<CitationViewModelFactory>()
    private lateinit var citationViewModel : CitationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val fragmentCitationBindging = FragmentCitationBinding.inflate(inflater, container, false)
        fragmentCitationBindging.textViewPhrase.text = "phrase1"
        fragmentCitationBindging.textViewAuthor.text = "auhor1"
        return fragmentCitationBindging.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        citationViewModel = citationViewModelFactory.create(CitationViewModel::class.java)
    }
}
