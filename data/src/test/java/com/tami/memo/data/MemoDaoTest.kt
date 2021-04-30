package com.tami.memo.data

import android.os.Build
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.tami.memo.data.db.LocalMemoDatabase
import com.tami.memo.data.db.MemoDao
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
    private val testMemoEntity2 = MemoEntity(2, "content 2")
    private val testMemoEntity3 = MemoEntity(3, "content 3")

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
    fun getMemo_return_memoEntity() = runBlocking {
        memoDao.insertMemo(testMemoEntity)
        val memo = memoDao.getMemo(1)
        MatcherAssert.assertThat(memo, Matchers.`is`(testMemoEntity))
    }

    @Test
    fun getMemo_return_null() = runBlocking {
        val memo = memoDao.getMemo(1)
        MatcherAssert.assertThat(memo, Matchers.nullValue())
    }

    @Test
    fun insertMemo() = runBlocking {
        val id = memoDao.insertMemo(testMemoEntity)
        MatcherAssert.assertThat(id, Matchers.`is`(listOf(1.toLong())))
    }

    @Test
    fun insertMemo_replace() = runBlocking {
        val id = memoDao.insertMemo(testMemoEntity)
        val replaceId = memoDao.insertMemo(MemoEntity(1, "contentInsertReplace"))
        MatcherAssert.assertThat(replaceId, Matchers.`is`(id))

        val memo = memoDao.getMemo(1)
        MatcherAssert.assertThat(memo?.content, Matchers.`is`("contentInsertReplace"))
    }

    @Test
    fun insertMemo_list() = runBlocking {
        val idList = memoDao.insertMemo(testMemoEntity, testMemoEntity2, testMemoEntity3)
        MatcherAssert.assertThat(idList, Matchers.`is`(listOf(1, 2, 3).map { it.toLong() }))
    }

    @Test
    fun updateMemo() = runBlocking {
        memoDao.insertMemo(testMemoEntity)

        val row = memoDao.updateMemo(MemoEntity(1, "contentUpdate"))
        MatcherAssert.assertThat(row, Matchers.`is`(1))

        val memo = memoDao.getMemo(1)
        MatcherAssert.assertThat(memo?.content, Matchers.`is`("contentUpdate"))
    }

    @Test
    fun update_memoList() = runBlocking {
        memoDao.insertMemo(testMemoEntity, testMemoEntity2, testMemoEntity3)

        val updateArray = arrayOf(
            MemoEntity(1, "contentUpdate 1"),
            MemoEntity(2, "contentUpdate 2"),
            MemoEntity(3, "contentUpdate 3")
        )
        val row = memoDao.updateMemo(*updateArray)
        MatcherAssert.assertThat(row, Matchers.`is`(3))

        val memoList = memoDao.getMemoList()
        MatcherAssert.assertThat(memoList.size, Matchers.`is`(3))
        memoList.forEachIndexed { index, memoEntity ->
            MatcherAssert.assertThat(memoEntity, Matchers.`is`(updateArray[index]))
        }
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

    @Test
    fun `deleteMemo_해당 메모 없을시_return_0`() = runBlocking {
        val deleteResult = memoDao.deleteMemo(MemoEntity(5, "test"))
        MatcherAssert.assertThat(deleteResult, Matchers.`is`(0))
    }

    @After
    fun after() {
        localMemoDatabase.close()
    }
}