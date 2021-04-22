package com.tami.memo.data.di

import android.content.Context
import androidx.room.Room
import com.tami.memo.data.db.LocalMemoDatabase
import com.tami.memo.data.db.MemoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideLocalMemoDatabase(@ApplicationContext context: Context): LocalMemoDatabase =
        Room.databaseBuilder(context, LocalMemoDatabase::class.java, "memoDatabase").build()

    @Provides
    @Singleton
    fun provideMemoDao(localMemoDatabase: LocalMemoDatabase): MemoDao =
        localMemoDatabase.memoDao()
}