package com.example.iab_odev7.room

import androidx.room.*
import com.example.iab_odev7.data.entity.Isler

@Dao
interface IslerDao {
    @Query("SELECT * FROM yapilacaklar")
    suspend fun isleriYukle() : List<Isler>

    @Insert
    suspend fun kaydet(work:Isler)

    @Update
    suspend fun guncelle(work:Isler)

    @Delete
    suspend fun sil(work:Isler)

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_is like '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi:String) : List<Isler>
}