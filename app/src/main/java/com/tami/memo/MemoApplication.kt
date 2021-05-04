package com.tami.memo

import android.app.Application
import com.facebook.stetho.Stetho
import com.tami.memo.base.isDebug
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        IS_DEBUG = isDebug()
        initTimber()
        initStetho()
    }

    private fun initTimber() {
        if (IS_DEBUG)
            Timber.plant(Timber.DebugTree())
    }

    private fun initStetho() {
        if (IS_DEBUG)
            Stetho.initializeWithDefaults(this)
    }

    companion object {
        var IS_DEBUG = false
    }
}