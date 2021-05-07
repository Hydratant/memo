package com.tami.memo.ui.insert

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import com.tami.memo.R
import com.tami.memo.base.BindingActivity
import com.tami.memo.base.showKeyboard
import com.tami.memo.common.EventObserver
import com.tami.memo.databinding.InsertActBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InsertActivity : BindingActivity<InsertActBinding>(R.layout.insert_act) {

    private val vm: InsertViewModel by viewModels()

    override fun onLoadOnce() {
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