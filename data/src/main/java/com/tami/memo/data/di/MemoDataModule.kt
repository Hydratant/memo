package com.tami.memo.data.di

import com.tami.memo.data.repo.MemoRepository
import com.tami.memo.data.repo.MemoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class MemoDataModule {
    @Binds
    abstract fun bindsMemoRepository(
        repository: MemoRepositoryImpl
    ): MemoRepository

}