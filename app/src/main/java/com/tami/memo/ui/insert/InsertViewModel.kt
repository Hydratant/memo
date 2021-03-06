package com.tami.memo.ui.insert

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tami.memo.base.MemoViewModel
import com.tami.memo.common.Event
import com.tami.memo.domain.usecase.InsertMemoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsertViewModel @Inject constructor(
    private val insertMemoUseCase: InsertMemoUseCase
) : MemoViewModel() {

    val content = MutableLiveData<String>()

    private val _showKeyboard = MutableLiveData<Event<Unit>>()
    val showKeyboard: LiveData<Event<Unit>> get() = _showKeyboard

    private val _insertSuccess = MutableLiveData<Event<Unit>>()
    val insertSuccess: LiveData<Event<Unit>> get() = _insertSuccess

    private val _insertFail = MutableLiveData<String>()
    val insertFail: LiveData<String> get() = _insertFail

    init {
        // 시작시 Keyboard 호출
        _showKeyboard.value = Event(Unit)
    }

    fun insert() {
        viewModelScope.launch {
            val insertContent = content.value ?: ""
            insertMemoUseCase(insertContent).fold({
                if (it) _insertSuccess.value = Event(Unit)
                else _insertFail.value = INSERT_FAIL_DEFAULT_MESSAGE
            }, {
                val throwableMessage = it.message ?: INSERT_FAIL_DEFAULT_MESSAGE
                _insertFail.value = throwableMessage
            })
        }
    }


    companion object {
        @VisibleForTesting
        const val INSERT_FAIL_DEFAULT_MESSAGE = "저장에 실패하였습니다."
    }
}