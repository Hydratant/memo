package com.tami.memo.ui.insert

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tami.memo.R
import com.tami.memo.base.MemoActivity
import com.tami.memo.databinding.InsertActBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InsertActivity : MemoActivity() {

    lateinit var bb: InsertActBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bb = DataBindingUtil.setContentView(this, R.layout.insert_act)
    }
}