package com.stellisee.gratitudetime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val citation = findViewById<TextView>(R.id.textView_citation).apply {
            text = "It takes twenty years to build a reputation and five minutes to ruin it. If you think about that, you'il fo things differently."
            text = "Death is not the greatest loss in life. The greatest loss is what dies inside us while we live."
        }
        val author = findViewById<TextView>(R.id.textView_author).apply {
            text = "Warren Buffett"
            text = "Norman Cousins"
        }
    }
}
