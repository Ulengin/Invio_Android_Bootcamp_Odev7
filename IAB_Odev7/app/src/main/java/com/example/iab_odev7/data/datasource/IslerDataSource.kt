package com.example.iab_odev7.data.datasource

import com.example.iab_odev7.data.entity.Isler
import com.example.iab_odev7.room.IslerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class IslerDataSource(var idao:IslerDao) {

    suspend fun kaydet(yapilacak_is:String){
        val yeni_is = Isler(0,yapilacak_is)
        idao.kaydet(yeni_is)
    }

    suspend fun guncelle(yapilacak_id:Int,yapilacak_is:String){
        val guncellenen_is = Isler(yapilacak_id,yapilacak_is)
        idao.guncelle(guncellenen_is)
    }

    suspend fun isleriYukle() : List<Isler> =
        withContext(Dispatchers.IO){
            idao.isleriYukle()
        }

    suspend fun ara(aramaKelimesi:String) : List<Isler> =
        withContext(Dispatchers.IO){
            idao.ara(aramaKelimesi)
        }

    suspend fun sil(yapilacak_id:Int) {
        val silinen_is = Isler(yapilacak_id,"")
        idao.sil(silinen_is)
    }
}