package com.tami.memo.domain.usecase

import com.tami.memo.data.model.Memo
import com.tami.memo.data.repo.MemoRepository
import javax.inject.Inject

class GetMemoListUseCase @Inject constructor(
    private val memoRepository: MemoRepository
) {
    suspend operator fun invoke(): Result<List<Memo>> =
        useCaseInvoke { memoRepository.getMemoList() }
}