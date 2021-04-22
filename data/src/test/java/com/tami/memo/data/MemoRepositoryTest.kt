package com.tami.memo.data

import com.nhaarman.mockitokotlin2.mock
import com.tami.memo.data.db.MemoDao
import com.tami.memo.data.entity.MemoEntity
import com.tami.memo.data.model.Memo
import com.tami.memo.data.repo.MemoRepository
import com.tami.memo.data.repo.MemoRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class MemoRepositoryTest {

    private val memoDao: MemoDao = mock()
    private lateinit var memoRepository: MemoRepository

    @Before
    fun init() {
        memoRepository = MemoRepositoryImpl(memoDao)
    }

    @Test
    fun getMemoList() = runBlocking {
        Mockito.`when`(memoDao.getMemoList())
            .thenReturn(listOf(MemoEntity(0, "memo1"), MemoEntity(1, "memo2")))

        val memoList = memoRepository.getMemoList()
        MatcherAssert.assertThat(memoList[0], Matchers.`is`(Memo(0, "memo1")))
        MatcherAssert.assertThat(memoList[1], Matchers.`is`(Memo(1, "memo2")))
    }


    @Test
    fun getMemo_returnMemo() = runBlocking {
        Mockito.`when`(memoDao.getMemo(0))
            .thenReturn(MemoEntity(0, "memo1"))

        val memo = memoRepository.getMemo(0)
        MatcherAssert.assertThat(memo, Matchers.`is`(Memo(0, "memo1")))
    }

    @Test
    fun getMemo_returnNull() = runBlocking {
        Mockito.`when`(memoDao.getMemo(0))
            .thenReturn(null)

        val memo = memoRepository.getMemo(0)
        MatcherAssert.assertThat(memo, Matchers.nullValue())
    }
}