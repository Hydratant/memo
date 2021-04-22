package com.tami.memo.data.repo

import com.tami.memo.data.model.Memo

interface MemoRepository {
    suspend fun getMemo(uid: Int): Memo
    suspend fun getMemoList(): List<Memo>
    suspend fun insertMemo(memo: Memo): List<Long>
    suspend fun deleteMemo(memo: Memo): Int
    suspend fun updateMemo(memo: Memo): Int
}