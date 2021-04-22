package com.tami.memo.domain.usecase

import com.nhaarman.mockitokotlin2.mock
import com.tami.memo.data.model.Memo
import com.tami.memo.data.repo.MemoRepository
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class DeleteMemoUseCaseTest {

    private val memoRepository: MemoRepository = mock()
    private lateinit var deleteMemoUseCase: DeleteMemoUseCase

    @Before
    fun init() {
        deleteMemoUseCase = DeleteMemoUseCase(memoRepository)
    }

    @Test
    fun `deleteMemo_해당하는 메모가 없을때_return_0`() = runBlocking {
        val memo = Memo(0, "content")
        Mockito.`when`(memoRepository.deleteMemo(memo))
            .thenReturn(0)

        val deleteResult = deleteMemoUseCase(memo)
        MatcherAssert.assertThat(deleteResult, Matchers.`is`(Result.Success(0)))
    }

    @Test
    fun `deleteMemo_해당하는 메모가 있을때_return_1`() = runBlocking {
        val memo = Memo(0, "content")
        Mockito.`when`(memoRepository.deleteMemo(memo))
            .thenReturn(1)

        val deleteResult = deleteMemoUseCase(memo)
        MatcherAssert.assertThat(deleteResult, Matchers.`is`(Result.Success(1)))
    }
}