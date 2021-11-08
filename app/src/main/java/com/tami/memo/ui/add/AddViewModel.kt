package com.tami.memo.ui.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tami.memo.base.MemoViewModel
import com.tami.memo.data.repo.MemoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val memoRepository: MemoRepository
) : MemoViewModel() {

    val title = MutableLiveData<String>()
    val content = MutableLiveData<String>()

    fun add() {
        viewModelScope.launch {
            if (title.value != null && content.value != null) {
                val notNullTitle = title.value ?: ""
                val notNullContent = content.value ?: ""
                memoRepository.insertMemo(notNullTitle, notNullContent)
            }
        }
    }
}
