package com.tami.memo.data

import androidx.room.*

@Dao
interface MemoDao {

    @Query("SELECT * FROM Memo ORDER BY uid ASC")
    suspend fun getMemoList(): List<MemoEntity>

    @Query("SELECT * FROM Memo WHERE uid = :id")
    suspend fun getMemo(id: Int): MemoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemo(memoEntity: MemoEntity)

    @Delete
    suspend fun deleteMemo(memoEntity: MemoEntity)

    @Update
    suspend fun updateMemo(memoEntity: MemoEntity)

}