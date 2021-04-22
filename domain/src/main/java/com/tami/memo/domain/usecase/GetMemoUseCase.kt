package com.tami.memo.domain.usecase

import com.tami.memo.data.model.Memo
import com.tami.memo.data.repo.MemoRepository
import java.lang.NullPointerException
import javax.inject.Inject

class GetMemoUseCase @Inject constructor(
    private val memoRepository: MemoRepository
) {
    suspend operator fun invoke(uid: Int): Result<Memo> =
        useCaseInvoke { memoRepository.getMemo(uid) }
}