package com.tami.memo.data

import com.tami.memo.data.model.Memo

interface MemoRepository {
    suspend fun getMemo(uid: Int): Memo
    suspend fun getMemoList(): List<Memo>
    suspend fun insertMemo(memo: Memo)
    suspend fun deleteMemo(memo: Memo)
    suspend fun updateMemo(memo: Memo)
}