package com.stellisee.gratitudetime.ui.citation

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stellisee.gratitudetime.databinding.ActivityCitationBinding

class CitationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityCitationBinding = ActivityCitationBinding.inflate(layoutInflater)
        val view = activityCitationBinding.root
        setContentView(view)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}
