package com.tami.memo.ui

import com.tami.memo.base.BaseActivity
import timber.log.Timber

class MainActivity : BaseActivity() {
    override fun onLoadOnce() {
        Timber.i("test")
    }
}