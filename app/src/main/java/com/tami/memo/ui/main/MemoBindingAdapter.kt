package com.tami.memo.ui.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tami.memo.data.model.Memo

object MemoBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:memoList")
    fun setMemoList(recyclerView: RecyclerView, memoList: MutableList<Memo>?) {
        recyclerView.adapter?.let { adapter ->
            if (adapter is MemoAdapter) {
                memoList?.let { items -> adapter.update(items) }
            }
            recyclerView.addItemDecoration(MemoItemDecoration(8f))
        } ?: run {
            recyclerView.adapter = MemoAdapter().apply {
                memoList?.let { items -> update(items) }
            }
        }
    }
}