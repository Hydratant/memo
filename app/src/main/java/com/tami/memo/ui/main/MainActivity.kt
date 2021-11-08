package com.tami.memo.ui.main

import android.view.LayoutInflater
import androidx.activity.viewModels
import com.tami.memo.base.ViewBindingActivity
import com.tami.memo.databinding.ActivityMainBinding
import com.tami.memo.ui.add.AddActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ViewBindingActivity<ActivityMainBinding>() {

    private val vm: MainViewModel by viewModels()

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = { ActivityMainBinding.inflate(it) }

    override fun onLoadOnce() {
        vm.memos.observe(this) {
            Timber.i("MemoList : $it")
        }
        bb.fabAdd.setOnClickListener {
            startActivity(AddActivity.getIntent(this))
        }
    }
}