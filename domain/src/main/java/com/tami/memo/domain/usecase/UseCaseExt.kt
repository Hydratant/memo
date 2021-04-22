package com.tami.memo.domain.usecase


inline fun <T> useCaseInvoke(function: () -> T): Result<T> {
    return runCatching { function() }
        .fold({ Result.Success(it) }, { Result.Error(it) })
}