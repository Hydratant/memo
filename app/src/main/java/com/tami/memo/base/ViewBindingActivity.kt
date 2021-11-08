package com.tami.memo.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

abstract class ViewBindingActivity<VB : ViewBinding> :
    BaseActivity() {

    lateinit var bb: VB
    abstract val bindingInflater: (LayoutInflater) -> VB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bb = bindingInflater.invoke(layoutInflater)
        setContentView(bb.root)
        onLoadOnce()
    }

    abstract fun onLoadOnce()
}