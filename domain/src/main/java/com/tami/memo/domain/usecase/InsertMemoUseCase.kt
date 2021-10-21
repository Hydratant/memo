package com.tami.memo.domain.usecase

import com.tami.memo.data.repo.MemoRepository
import com.tami.memo.domain.base.UseCase
import com.tami.memo.share.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher

class InsertMemoUseCase constructor(
    private val memoRepository: MemoRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<InsertMemoUseCase.Param, Unit>(dispatcher) {

    override suspend fun execute(param: Param) {
        memoRepository.insertMemo(param.title, param.content)
    }

    data class Param(
        val title: String,
        val content: String
    )
}
