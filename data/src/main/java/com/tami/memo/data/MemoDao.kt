package com.tami.memo.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface MemoDao {

    @Query("SELECT * From Memo")
    suspend fun getMemoList(): List<MemoEntity>
}