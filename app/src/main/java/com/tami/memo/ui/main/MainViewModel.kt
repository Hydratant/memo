package com.tami.memo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tami.memo.base.MemoViewModel
import com.tami.memo.common.Event
import com.tami.memo.data.model.Memo
import com.tami.memo.domain.usecase.GetMemoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMemoListUseCase: GetMemoListUseCase
) : MemoViewModel() {

    private val _memoList = MutableLiveData<MutableList<Memo>>()
    val memoList: LiveData<MutableList<Memo>> = _memoList

    private val _errorMessage = MutableLiveData<Event<String>>()
    val errorMessage: LiveData<Event<String>> = _errorMessage

    private val _goInsert = MutableLiveData<Event<Unit>>()
    val goInsert: LiveData<Event<Unit>> = _goInsert

    init {
        getMemoList()
    }

    fun getMemoList() {
        viewModelScope.launch {
            getMemoListUseCase().fold({ _memoList.value = it.toMutableList() }, {
                val errorMessage = it.message ?: "errorMessage"
                _errorMessage.value = Event(errorMessage)
            })
        }
    }

    fun goInsert() {
        _goInsert.value = Event(Unit)
    }
}