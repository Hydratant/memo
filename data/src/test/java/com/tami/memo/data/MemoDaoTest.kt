package com.tami.memo.data

import android.os.Build
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.tami.memo.data.entity.MemoEntity
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O])
@RunWith(RobolectricTestRunner::class)
class MemoDaoTest {

    private lateinit var memoDao: MemoDao
    private lateinit var localMemoDatabase: LocalMemoDatabase

    private val testMemoEntity = MemoEntity(1, "content 1")

    @Before
    fun before() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        localMemoDatabase =
            Room.inMemoryDatabaseBuilder(context, LocalMemoDatabase::class.java).build()
        memoDao = localMemoDatabase.memoDao()
    }

    @Test
    fun getMemoList_isEmpty() = runBlocking {
        val memoList = memoDao.getMemoList()
        MatcherAssert.assertThat(memoList.size, Matchers.`is`(0))
    }

    @Test
    fun getMemoList_isNotEmpty() = runBlocking {
        memoDao.insertMemo(testMemoEntity)
        val memoList = memoDao.getMemoList()
        MatcherAssert.assertThat(memoList.size, Matchers.`is`(1))
    }

    @Test
    fun getMemo() = runBlocking {
        memoDao.insertMemo(testMemoEntity)
        val memo = memoDao.getMemo(1)
        MatcherAssert.assertThat(memo, Matchers.`is`(testMemoEntity))
    }

    @Test
    fun insertMemo() = runBlocking {
        memoDao.insertMemo(testMemoEntity)
        val memo = memoDao.getMemo(1)
        MatcherAssert.assertThat(memo, Matchers.`is`(testMemoEntity))
    }

    @Test
    fun updateMemo() = runBlocking {
        memoDao.insertMemo(testMemoEntity)
        memoDao.updateMemo(MemoEntity(1, "contentUpdate"))
        val memo = memoDao.getMemo(1)
        MatcherAssert.assertThat(memo.content, Matchers.`is`("contentUpdate"))
    }

    @Test
    fun deleteMemo() = runBlocking {
        val memoList = memoDao.getMemoList()
        MatcherAssert.assertThat(memoList.size, Matchers.`is`(0))

        memoDao.insertMemo(testMemoEntity)
        val insertAfterMemoList = memoDao.getMemoList()
        MatcherAssert.assertThat(insertAfterMemoList.size, Matchers.`is`(1))

        memoDao.deleteMemo(testMemoEntity)
        val deleteAfterMemoList = memoDao.getMemoList()
        MatcherAssert.assertThat(deleteAfterMemoList.size, Matchers.`is`(0))
    }

    @After
    fun after() {
        localMemoDatabase.close()
    }
}