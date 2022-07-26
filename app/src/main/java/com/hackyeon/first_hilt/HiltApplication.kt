package com.hackyeon.first_hilt

import android.app.Application
import android.content.res.Resources
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init() {
        instance = this
        res = resources
    }

    companion object {
        lateinit var instance: HiltApplication
        lateinit var res: Resources
    }
}