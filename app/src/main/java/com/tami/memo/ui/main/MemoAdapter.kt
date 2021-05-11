package com.tami.memo.ui.main

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tami.memo.base.dp2px
import com.tami.memo.data.model.Memo
import com.tami.memo.databinding.MemoItemBinding

class MemoAdapter : RecyclerView.Adapter<MemoItemHolder>() {

    private val items = mutableListOf<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoItemHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val bb = MemoItemBinding.inflate(inflater, parent, false)
        return MemoItemHolder(bb)
    }

    override fun onBindViewHolder(holder: MemoItemHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    fun update(memoList: List<Memo>) {
        val diffCallBack = MemoDiffUtil(items, memoList)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        items.clear()
        items.addAll(memoList)
        diffResult.dispatchUpdatesTo(this)
    }
}


class MemoItemHolder(private val bb: MemoItemBinding) : RecyclerView.ViewHolder(bb.root) {
    fun bind(item: Memo) {
        with(bb) {
            this.item = item
        }
    }
}

class MemoItemDecoration(
    private val dp: Float
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val context = view.context
        val offset = context.dp2px(dp)
        outRect.set(offset, offset, offset, offset)
    }
}