package com.tami.memo.domain.usecase

import com.nhaarman.mockitokotlin2.mock
import com.tami.memo.data.repo.MemoRepository
import org.junit.Before

class GetMemoListUseCaseTest {

    private val memoRepository: MemoRepository = mock()
    private lateinit var getMemoListUseCase: GetMemoListUseCase

    @Before
    fun init() {
        getMemoListUseCase = GetMemoListUseCase(memoRepository)
    }


}