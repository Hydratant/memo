package com.tami.memo.data.db

import androidx.room.*
import com.tami.memo.data.entity.MemoEntity

@Dao
interface MemoDao {

    /**
     * get MemoList
     * @return 전체 Memo List
     */
    @Query("SELECT * FROM Memo ORDER BY uid ASC")
    suspend fun getMemoList(): List<MemoEntity>

    /**
     * Get Memo
     * @param uid Memo Id
     * @return 해당 Entity
     */
    @Query("SELECT * FROM Memo WHERE uid = :uid")
    suspend fun getMemo(uid: Int): MemoEntity?

    /**
     * Memo Insert
     * @param memoEntity 삽입할 MemoEntity
     * @return 삽입한 rowId List
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemo(vararg memoEntity: MemoEntity): List<Long>

    /**
     * Memo Delete
     * @param memoEntity 삭제할 MemoEntity
     * @return 삭제한 Row 개수
     */
    @Delete
    suspend fun deleteMemo(vararg memoEntity: MemoEntity): Int

    /**
     * Memo Update
     * @param memoEntity 갱신할 MemoEntity
     * @return 갱신한 Row 개수
     */
    @Update
    suspend fun updateMemo(vararg memoEntity: MemoEntity): Int

}