package com.tami.memo.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Memo")
data class MemoEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    val title: String,
    val content: String
)