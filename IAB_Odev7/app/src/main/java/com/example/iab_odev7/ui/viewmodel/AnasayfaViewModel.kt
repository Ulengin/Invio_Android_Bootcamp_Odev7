package com.example.iab_odev7.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.iab_odev7.data.entity.Isler
import com.example.iab_odev7.data.repo.IslerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var irepo:IslerRepository) : ViewModel() {
    var islerListesi = MutableLiveData<List<Isler>>()

    init {
        isleriYukle()
    }

    fun isleriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = irepo.isleriYukle()
        }
    }

    fun ara(aramaKelimesi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = irepo.ara(aramaKelimesi)
        }
    }

    fun sil(yapilacak_id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            irepo.sil(yapilacak_id)
            isleriYukle()
        }
    }
}