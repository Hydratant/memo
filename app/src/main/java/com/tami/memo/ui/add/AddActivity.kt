package com.tami.memo.ui.add

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import com.tami.memo.R
import com.tami.memo.base.BindingActivity
import com.tami.memo.databinding.ActivityAddBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddActivity : BindingActivity<ActivityAddBinding>(R.layout.activity_add) {

    private val vm: AddViewModel by viewModels()

    override fun bind() {
        bb.vm = vm
    }

    companion object {
        fun getIntent(context: Context): Intent =
            Intent(context, AddActivity::class.java)
    }
}