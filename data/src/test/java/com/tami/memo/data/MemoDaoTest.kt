package com.tami.memo.data

import android.os.Build
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.tami.memo.data.db.LocalMemoDatabase
import com.tami.memo.data.db.MemoDao
import com.tami.memo.data.entity.MemoEntity
import kotlinx.coroutines.*
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@ExperimentalCoroutinesApi
@Config(sdk = [Build.VERSION_CODES.O])
@RunWith(RobolectricTestRunner::class)
class MemoDaoTest {

    private lateinit var memoDao: MemoDao
    private lateinit var localMemoDatabase: LocalMemoDatabase

    @Before
    fun before() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        localMemoDatabase =
            Room.inMemoryDatabaseBuilder(context, LocalMemoDatabase::class.java).build()
        memoDao = localMemoDatabase.memoDao()
    }

    @Test
    fun insertMemo() = runBlocking {
        withContext(Dispatchers.IO) {
            val testMemo = MemoEntity(1, "title1", "content1")
            memoDao.insertMemo(testMemo)
            MatcherAssert.assertThat(memoDao.getMemos()[0], Matchers.`is`(testMemo))
            MatcherAssert.assertThat(memoDao.getMemoById(1), Matchers.`is`(testMemo))
        }
    }

    //
    @Test
    fun deleteMemo() = runBlocking {
        withContext(Dispatchers.IO) {
            val testMemo = MemoEntity(1, "title1", "content1")
            memoDao.insertMemo(testMemo)
            MatcherAssert.assertThat(memoDao.getMemos()[0], Matchers.`is`(testMemo))
            memoDao.deleteMemoById(1)
            MatcherAssert.assertThat(memoDao.getMemos().size, Matchers.`is`(0))
        }
    }

    @Test
    fun updateMemo() = runBlocking {
        withContext(Dispatchers.IO) {
            val testMemo = MemoEntity(1, "title1", "content1")
            val updateMemo = MemoEntity(1, "title2", "content2")
            memoDao.insertMemo(testMemo)
            MatcherAssert.assertThat(memoDao.getMemos()[0], Matchers.`is`(testMemo))
            memoDao.updateMemo(updateMemo)
            MatcherAssert.assertThat(memoDao.getMemos()[0], Matchers.`is`(updateMemo))
        }
    }

    fun updateContent() = runBlocking {
        withContext(Dispatchers.IO) {
            val testMemo = MemoEntity(1, "title1", "content1")
            val updateContent = "content2"
            memoDao.insertMemo(testMemo)
            MatcherAssert.assertThat(memoDao.getMemos()[0], Matchers.`is`(testMemo))
            memoDao.updateContentToMemo(1, updateContent)
            MatcherAssert.assertThat(memoDao.getMemos()[0].content, Matchers.`is`(updateContent))
        }
    }

    @After
    fun after() {
        localMemoDatabase.close()
    }
}