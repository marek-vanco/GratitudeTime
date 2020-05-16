package com.stellisee.gratitudetime.ui.citation

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stellisee.gratitudetime.databinding.ActivityCitationBinding
import kotlinx.coroutines.InternalCoroutinesApi
import timber.log.Timber

class CitationActivity : AppCompatActivity() {

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.plant(Timber.DebugTree());
        val viewBinding = ActivityCitationBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}
