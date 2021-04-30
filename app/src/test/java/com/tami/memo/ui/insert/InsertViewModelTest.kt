package com.tami.memo.ui.insert

import android.os.Build
import com.nhaarman.mockitokotlin2.mock
import com.tami.memo.common.Event
import com.tami.memo.domain.usecase.InsertMemoUseCase
import com.tami.memo.domain.usecase.Result
import com.tami.memo.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
@Config(sdk = [Build.VERSION_CODES.O])
@RunWith(RobolectricTestRunner::class)
class InsertViewModelTest {

    private val insertMemoUseCase: InsertMemoUseCase = mock()
    lateinit var insertViewModel: InsertViewModel

    @Before
    fun init() {
        insertViewModel = InsertViewModel(insertMemoUseCase)
    }


    @Test
    fun `insertSuccess_insertMemoUseCase_return_true_liveDataValue_true`() = runBlockingTest {
        Mockito.`when`(insertMemoUseCase("content"))
            .thenReturn(Result.Success(true))
        insertViewModel.insert("content")
        MatcherAssert.assertThat(
            insertViewModel.insertSuccess.getOrAwaitValue(), Matchers.instanceOf(Event::class.java)
        )
    }

    @Test
    fun `insertSuccess_insertMemoUseCase_return_false_liveDataValue_failMessage`() =
        runBlockingTest {
            Mockito.`when`(insertMemoUseCase("content"))
                .thenReturn(Result.Success(false))

            insertViewModel.insert("content")
            MatcherAssert.assertThat(
                insertViewModel.insertFail.getOrAwaitValue(),
                Matchers.`is`(InsertViewModel.INSERT_FAIL_DEFAULT_MESSAGE)
            )
        }


    @Test
    fun `insertSuccess_insertMemoUseCase_return_fail_liveDataValue_throwableMessage`() =
        runBlockingTest {
            val exceptionMessage = "insertMemoUseCase Exception"
            Mockito.`when`(insertMemoUseCase("content"))
                .thenReturn(Result.Error(IllegalArgumentException(exceptionMessage)))

            insertViewModel.insert("content")
            MatcherAssert.assertThat(
                insertViewModel.insertFail.getOrAwaitValue(),
                Matchers.`is`(exceptionMessage)
            )
        }
}