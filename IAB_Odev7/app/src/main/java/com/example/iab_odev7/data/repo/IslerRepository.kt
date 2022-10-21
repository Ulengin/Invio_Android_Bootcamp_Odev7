package com.example.iab_odev7.data.repo

import com.example.iab_odev7.data.datasource.IslerDataSource
import com.example.iab_odev7.data.entity.Isler

class IslerRepository (var ids:IslerDataSource){
    suspend fun kaydet(yapilacak_is:String) = ids.kaydet(yapilacak_is)

    suspend fun guncelle(yapilacak_id:Int,yapilacak_is:String) = ids.guncelle(yapilacak_id,yapilacak_is)

    suspend fun isleriYukle() : List<Isler> = ids.isleriYukle()

    suspend fun ara(aramaKelimesi:String) : List<Isler> = ids.ara(aramaKelimesi)

    suspend fun sil(yapilacak_id:Int) = ids.sil(yapilacak_id)
}