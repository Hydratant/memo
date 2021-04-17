package com.tami.memo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Memo")
data class MemoEntity(
    @PrimaryKey val uid: Int,
    val content: String
)