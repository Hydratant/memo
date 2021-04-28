package com.tami.memo

import android.app.Application
import com.tami.memo.base.isDebug
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        IS_DEBUG = isDebug()
        initTimber()
    }

    private fun initTimber() {
        if (IS_DEBUG)
            Timber.plant(Timber.DebugTree())
    }

    companion object {
        var IS_DEBUG = false
    }
}