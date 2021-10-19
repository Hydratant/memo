package com.tami.memo.data.db

import androidx.room.*
import com.tami.memo.data.entity.MemoEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface MemoDao {

    @Query("SELECT * FROM Memo")
    fun observeMemos(): Flow<List<MemoEntity>>

    @Query("SELECT * FROM Memo")
    suspend fun getMemos(): List<MemoEntity>

    @Query("SELECT * FROM Memo WHERE uid = :id")
    fun observeMemoById(id: Int): Flow<MemoEntity>

    @Query("SELECT * FROM Memo WHERE uid = :id")
    suspend fun getMemoById(id: Int): MemoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemo(memoEntity: MemoEntity)

    @Update
    suspend fun updateMemo(memoEntity: MemoEntity): Int

    @Query("UPDATE Memo SET content = :content WHERE uid = :id")
    suspend fun updateContentToMemo(id: Int, content: String)

    @Query("DELETE FROM Memo WHERE uid = :id")
    suspend fun deleteMemoById(id: Int): Int
}