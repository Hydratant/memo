package com.tami.memo.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BindingActivity<B : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    BaseActivity() {

    protected lateinit var bb: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bb = DataBindingUtil.setContentView(this, layoutResId)
        bb.apply { this.lifecycleOwner = this@BindingActivity }
    }
}