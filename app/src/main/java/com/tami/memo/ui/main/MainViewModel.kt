package com.tami.memo.ui.main

import androidx.lifecycle.asLiveData
import com.tami.memo.base.MemoViewModel
import com.tami.memo.domain.usecase.ObserveMemoListUseCase
import com.tami.memo.share.successOr
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    observeMemoListUseCase: ObserveMemoListUseCase
) : MemoViewModel() {

    val memos = observeMemoListUseCase().successOr(flowOf(emptyList())).asLiveData()
}