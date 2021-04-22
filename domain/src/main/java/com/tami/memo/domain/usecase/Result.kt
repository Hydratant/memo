package com.tami.memo.domain.usecase

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val throwable: Throwable) : Result<Nothing>()

    fun fold(success: (R) -> Any, error: (throwable: Throwable) -> Any): Any =
        when (this) {
            is Success -> success(data)
            is Error -> error(throwable)
        }
}