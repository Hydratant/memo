package com.tami.memo.domain.usecase

import com.tami.memo.data.model.Memo
import com.tami.memo.data.repo.MemoRepository
import javax.inject.Inject

class InsertMemoUseCase @Inject constructor(
    private val memoRepository: MemoRepository
) {
    suspend operator fun invoke(memo: Memo): Result<List<Long>> =
        useCaseInvoke { memoRepository.insertMemo(memo) }
}