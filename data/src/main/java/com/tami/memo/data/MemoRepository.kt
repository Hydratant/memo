package com.tami.memo.data

interface MemoRepository {
    suspend fun getMemo(): MemoEntity
    suspend fun getMemoList(): List<MemoEntity>
    suspend fun insertMemo(memoEntity: MemoEntity)
    suspend fun deleteMemo(id: String)
    suspend fun updateMemo(memoEntity: MemoEntity)
}