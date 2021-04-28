package com.tami.memo.data.di

import com.tami.memo.data.db.MemoDao
import com.tami.memo.data.repo.MemoRepository
import com.tami.memo.data.repo.MemoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MemoRepositoryModule {

    @Provides
    @Singleton
    fun provideMemoRepository(memoDao: MemoDao): MemoRepository =
        MemoRepositoryImpl(memoDao)

}