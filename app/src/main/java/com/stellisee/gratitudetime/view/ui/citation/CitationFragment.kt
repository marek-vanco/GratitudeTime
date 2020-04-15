package com.stellisee.gratitudetime.view.ui.citation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stellisee.gratitudetime.R
import com.stellisee.gratitudetime.databinding.FragmentCitationBinding
import com.stellisee.gratitudetime.viewmodel.CitationViewModel

class CitationFragment() : Fragment() {

    private lateinit var citationViewModel : CitationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentCitationBinding.inflate(inflater, container, false)
        binding.citationViewModel = citationViewModel


    return inflater.inflate(R.layout.fragment_citation, container, false);
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
