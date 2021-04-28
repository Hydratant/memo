package com.tami.memo.domain.usecase

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val throwable: Throwable) : Result<Nothing>()

    fun fold(success: (R) -> Unit, error: (throwable: Throwable) -> Unit): Any =
        when (this) {
            is Success -> success(data)
            is Error -> error(throwable)
        }
}