package com.stellisee.gratitudetime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CitationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_citation, container, false)
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
