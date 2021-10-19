package com.tami.memo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tami.memo.data.entity.MemoEntity

@Database(entities = [MemoEntity::class], version = 1, exportSchema = true)
internal abstract class LocalMemoDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao
}