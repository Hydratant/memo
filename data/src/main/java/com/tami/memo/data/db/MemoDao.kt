package com.tami.memo.data.db

import androidx.room.*
import com.tami.memo.data.entity.MemoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {

    @Query("SELECT * FROM Memo")
    fun observeMemos(): Flow<List<MemoEntity>>

    @Query("SELECT * FROM Memo")
    fun getMemos(): List<MemoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemo(memoEntity: MemoEntity)

    @Update
    suspend fun updateMemo(memoEntity: MemoEntity): Int

    @Query("UPDATE Memo SET content = :content WHERE uid = :uid")
    suspend fun updateMemoContent(uid: Int, content: String)

    @Query("DELETE FROM Memo WHERE uid = :uid")
    suspend fun deleteMemoById(uid: Int): Int
}