package com.tami.memo.data.repo

import android.os.Build
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.tami.memo.data.db.LocalMemoDatabase
import com.tami.memo.data.db.MemoDao
import com.tami.memo.data.entity.MemoEntity
import com.tami.memo.data.model.Memo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
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
class MemoRepositoryTest {

    private lateinit var memoDao: MemoDao
    private lateinit var localMemoDatabase: LocalMemoDatabase
    private lateinit var memoRepository: MemoRepository


    @Before
    fun init() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        localMemoDatabase =
            Room.inMemoryDatabaseBuilder(context, LocalMemoDatabase::class.java).build()
        memoDao = localMemoDatabase.memoDao()
        memoRepository = MemoRepositoryImpl(memoDao)
    }


    @Test
    fun insertMemo() = runBlocking {
        withContext(Dispatchers.IO) {
            val testMemo = Memo(1, "title1", "content1")
            memoRepository.insertMemo(testMemo)
            val resultMemo = memoRepository.getMemo(1)
            MatcherAssert.assertThat(resultMemo?.content, Matchers.`is`("content1"))
            MatcherAssert.assertThat(resultMemo?.title, Matchers.`is`("title1"))
        }
    }


    @After
    fun after() {
        localMemoDatabase.close()
    }

}