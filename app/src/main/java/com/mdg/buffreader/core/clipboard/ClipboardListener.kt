package com.mdg.buffreader.core.clipboard

import android.content.ClipboardManager.OnPrimaryClipChangedListener
import android.content.Context
import android.widget.Toast

class ClipboardListener(private val context: Context) : OnPrimaryClipChangedListener {

    private var url: String = ""

    override fun onPrimaryClipChanged() {

        val tempText = MyClipboardManager.INSTANCE.readFromClipboard()
        if (tempText.isNotEmpty()) {
            if (url.isEmpty()) {
                url = tempText
                Toast.makeText(context, url, Toast.LENGTH_SHORT).show()
                //downl
            } else if (url != tempText) {
                url = tempText
                Toast.makeText(context, url, Toast.LENGTH_SHORT).show()
            }
        }
    }
}