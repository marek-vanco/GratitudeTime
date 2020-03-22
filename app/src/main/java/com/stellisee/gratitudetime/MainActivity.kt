package com.stellisee.gratitudetime

import android.content.res.Configuration
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_citation)

        findViewById<TextView>(R.id.textView_citation).apply {
            text = "It takes twenty years to build a reputation and five minutes to ruin it. If you think about that, you'il fo things differently."
            text = "Death is not the greatest loss in life. The greatest loss is what dies inside us while we live."
        }
        findViewById<TextView>(R.id.textView_author).apply {
            text = "Warren Buffett"
            text = "Norman Cousins"
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}
