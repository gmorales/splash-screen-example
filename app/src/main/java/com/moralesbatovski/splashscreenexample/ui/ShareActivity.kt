package com.moralesbatovski.splashscreenexample.ui

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.moralesbatovski.splashscreenexample.R

/**
 * @author Gustavo Morales
 */
class ShareActivity : SplashedActivity() {

    private val helloText by lazy { findViewById<TextView>(R.id.shared_text) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        getUser()?.let {
            helloText.text = "${it.login}\n${intent.getStringExtra(Intent.EXTRA_TEXT)}"
        }
    }
}
