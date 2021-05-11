package com.tami.memo.ui.main

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.tami.memo.R
import com.tami.memo.base.BindingActivity
import com.tami.memo.common.EventObserver
import com.tami.memo.databinding.MainActBinding
import com.tami.memo.ui.insert.InsertActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<MainActBinding>(R.layout.main_act) {

    private val insertActivityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            vm.getMemoList()
        }

    private val vm: MainViewModel by viewModels()
    override fun onLoadOnce() {
        bb.vm = vm
        vm.goInsert.observe(this, EventObserver {
            insertActivityResultLauncher.launch(InsertActivity.getIntent(this))
        })
    }
}