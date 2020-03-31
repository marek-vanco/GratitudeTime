package com.stellisee.gratitudetime.view.ui

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.stellisee.gratitudetime.R

class CitationActivity : AppCompatActivity() {

    private val TAG: String = "CitationActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_citation)
        } catch (e: Exception) {
            Log.e(TAG, "exception=", e);
            throw e
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}
