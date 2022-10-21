package com.example.iab_odev7.di

import android.content.Context
import androidx.room.Room
import com.example.iab_odev7.data.datasource.IslerDataSource
import com.example.iab_odev7.data.repo.IslerRepository
import com.example.iab_odev7.room.IslerDao
import com.example.iab_odev7.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideIslerRepository(ids:IslerDataSource) : IslerRepository {
        return IslerRepository(ids)
    }

    @Provides
    @Singleton
    fun provideIslerDataSource(idao:IslerDao) : IslerDataSource {
        return IslerDataSource(idao)
    }

    @Provides
    @Singleton
    fun provideIslerDao(@ApplicationContext context: Context) : IslerDao {
        val vt = Room.databaseBuilder(context, Veritabani::class.java,"yapilacaklar.sqlite")
            .createFromAsset("yapilacaklar.sqlite").build()
        return vt.getIslerDao()
    }
}