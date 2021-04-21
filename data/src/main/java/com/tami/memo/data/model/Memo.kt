package com.tami.memo.data.model

import com.tami.memo.data.entity.MemoEntity

data class Memo(
    val uid: Int = 0,
    val content: String
)

fun MemoEntity.toMemo(): Memo = Memo(uid, content)
fun Memo.toMemoEntity(): MemoEntity = MemoEntity(uid, content)