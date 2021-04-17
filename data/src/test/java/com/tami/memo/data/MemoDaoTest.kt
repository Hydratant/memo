package com.tami.memo.data

import android.os.Build
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@HiltAndroidTest
@Config(application = HiltTestApplication::class, minSdk = Build.VERSION_CODES.O)
@RunWith(RobolectricTestRunner::class)
@ExperimentalCoroutinesApi
class MemoDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var localMemoDatabase: LocalMemoDatabase

    @Inject
    lateinit var memoDao: MemoDao

    @Before
    fun before() {
        hiltRule.inject()
    }

    @Test
    fun insertMemo() = runBlockingTest {
        val memoEntity = MemoEntity(content = "test")
        memoDao.insertMemo(memoEntity)
    }
}