package com.tami.memo.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

abstract class ViewBindingActivity<VB : ViewBinding> :
    BaseActivity() {

    private var _bb: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val bb: VB
        get() = _bb as VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _bb = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_bb).root)
        onLoadOnce()
    }

    abstract fun onLoadOnce()
    override fun onDestroy() {
        super.onDestroy()
        _bb = null
    }
}