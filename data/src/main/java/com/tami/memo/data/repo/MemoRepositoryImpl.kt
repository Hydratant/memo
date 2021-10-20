package com.tami.memo.data.repo

import com.tami.memo.data.db.MemoDao
import com.tami.memo.data.entity.toMemo
import com.tami.memo.data.entity.toMemoEntity
import com.tami.memo.data.model.Memo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MemoRepositoryImpl @Inject constructor(
    private val memoDao: MemoDao
) : MemoRepository {
    override fun observeMemos(): Flow<List<Memo>> {
        return memoDao.observeMemos()
            .map { it.map { memoEntity -> memoEntity.toMemo() } }
    }

    override suspend fun getMemo(id: Int): Memo? {
        return memoDao.getMemoById(id)?.toMemo()
    }

    override suspend fun insertMemo(memo: Memo) {
        memoDao.insertMemo(memo.toMemoEntity())
    }

    override suspend fun updateContentToMemo(id: Int, content: String): Int {
        return memoDao.updateContentToMemo(id, content)
    }

    override suspend fun deleteMemoById(id: Int): Int {
        return memoDao.deleteMemoById(id)
    }
}