package com.mdg.buffreader.core.application

import android.app.Application
import android.content.ClipboardManager
import android.content.Context
import com.mdg.buffreader.core.clipboard.ClipboardListener
import com.mdg.buffreader.core.clipboard.MyClipboardManager

class App : Application() {

    companion object {
        lateinit var INSTANCE: App

        fun applicationContext(): Context = INSTANCE.applicationContext
    }

    init {
        INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()
        val clipBoard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        clipBoard.addPrimaryClipChangedListener(ClipboardListener(this))

        MyClipboardManager.initialise(this)
    }
}