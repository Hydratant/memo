package com.tami.memo.domain.usecase

import com.tami.memo.data.model.Memo
import com.tami.memo.data.repo.MemoRepository
import com.tami.memo.domain.base.FlowNoParamUseCase
import com.tami.memo.share.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveMemoListUseCase @Inject constructor(
    private val memoRepository: MemoRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : FlowNoParamUseCase<List<Memo>>(dispatcher) {
    override fun execute(): Flow<List<Memo>> {
        return memoRepository.observeMemos()
    }
}