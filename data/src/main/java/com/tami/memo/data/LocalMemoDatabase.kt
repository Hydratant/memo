package com.tami.memo.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MemoEntity::class], version = 1)
abstract class LocalMemoDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao
}