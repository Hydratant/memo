package com.tami.memo.data

import android.os.Build
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.runBlocking
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

    @Before
    fun before() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        localMemoDatabase =
            Room.inMemoryDatabaseBuilder(context, LocalMemoDatabase::class.java).build()
        memoDao = localMemoDatabase.memoDao()
    }

    @Test
    fun insertMemo() = runBlocking {
    }

    @After
    fun after() {
        localMemoDatabase.close()
    }
}