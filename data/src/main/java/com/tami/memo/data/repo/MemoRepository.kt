package com.tami.memo.data.repo

import com.tami.memo.data.model.Memo
import kotlinx.coroutines.flow.Flow

interface MemoRepository {
    fun observeMemos(): Flow<Memo>
    fun getMemo(): Memo
    suspend fun insertMemo(memo: Memo)
    suspend fun updateContentToMemo(id: Int, content: String): Int
    suspend fun deleteMemoById(id: Int): Int
}