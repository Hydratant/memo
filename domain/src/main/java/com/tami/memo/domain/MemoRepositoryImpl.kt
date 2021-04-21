package com.tami.memo.domain

import com.tami.memo.data.*
import com.tami.memo.data.model.Memo
import com.tami.memo.data.model.toMemo
import com.tami.memo.data.model.toMemoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MemoRepositoryImpl constructor(
    private val memoDao: MemoDao
) : MemoRepository {
    override suspend fun getMemo(uid: Int): Memo = withContext(Dispatchers.IO) {
        memoDao.getMemo(uid).toMemo()
    }

    override suspend fun getMemoList(): List<Memo> = withContext(Dispatchers.IO) {
        memoDao.getMemoList().map { it.toMemo() }
    }

    override suspend fun insertMemo(memo: Memo) {
        withContext(Dispatchers.IO) { memoDao.insertMemo(memo.toMemoEntity()) }
    }

    override suspend fun deleteMemo(memo: Memo) {
        withContext(Dispatchers.IO) { memoDao.deleteMemo(memo.toMemoEntity()) }
    }

    override suspend fun updateMemo(memo: Memo) {
        withContext(Dispatchers.IO) { memoDao.updateMemo(memo.toMemoEntity()) }
    }
}