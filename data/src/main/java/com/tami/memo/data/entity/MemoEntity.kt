package com.tami.memo.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tami.memo.data.model.Memo

@Entity(tableName = "Memo")
data class MemoEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    val content: String
)

fun MemoEntity.toMemo(): Memo = Memo(uid, content)
fun Memo.toMemoEntity(): MemoEntity = MemoEntity(uid, content)