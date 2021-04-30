package com.tami.memo.ui.insert

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.tami.memo.R
import com.tami.memo.base.MemoActivity
import com.tami.memo.base.showKeyboard
import com.tami.memo.common.EventObserver
import com.tami.memo.databinding.InsertActBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InsertActivity : MemoActivity() {

    lateinit var bb: InsertActBinding
    private val vm: InsertViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bb = DataBindingUtil.setContentView(this, R.layout.insert_act)
        init()
    }

    private fun init() {
        bb.lifecycleOwner = this
        bb.vm = vm

        vm.showKeyboard.observe(this, EventObserver {
            bb.content.showKeyboard()
        })
    }

    companion object {
        fun getIntent(context: Context): Intent =
            Intent(context, InsertActivity::class.java)
    }
}