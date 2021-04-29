package com.tami.memo.ui.insert

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tami.memo.base.MemoViewModel
import com.tami.memo.common.Event
import com.tami.memo.domain.usecase.InsertMemoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class InsertViewModel @Inject constructor(
    private val insertMemoUseCase: InsertMemoUseCase
) : MemoViewModel() {

    private val _insertSuccess = MutableLiveData<Boolean>()
    val insertSuccess: LiveData<Boolean> get() = _insertSuccess

    fun insert(content: String) {
        viewModelScope.launch {
            insertMemoUseCase(content).fold({
                _insertSuccess.value = it
            }, {

            })
        }
    }
}