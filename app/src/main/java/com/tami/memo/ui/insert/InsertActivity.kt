package com.tami.memo.ui.insert

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

        vm.insertFail.observe(this) {
            it?.let { message -> Toast.makeText(this, message, Toast.LENGTH_LONG).show() }
        }

        vm.insertSuccess.observe(this, EventObserver {
            setResult(Activity.RESULT_OK)
            finish()
        })
    }

    companion object {
        fun getIntent(context: Context): Intent =
            Intent(context, InsertActivity::class.java)
    }
}