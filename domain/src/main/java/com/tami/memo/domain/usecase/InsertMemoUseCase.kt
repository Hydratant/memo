package com.tami.memo.domain.usecase

import com.tami.memo.data.model.Memo
import com.tami.memo.data.repo.MemoRepository
import javax.inject.Inject

class InsertMemoUseCase @Inject constructor(
    private val memoRepository: MemoRepository
) {
    suspend operator fun invoke(content: String): Result<Boolean> =
        useCaseInvoke {
            val memo = Memo(content = content)
            val insertSuccessList = memoRepository.insertMemo(memo)
            insertSuccessList.isNotEmpty()
        }
}