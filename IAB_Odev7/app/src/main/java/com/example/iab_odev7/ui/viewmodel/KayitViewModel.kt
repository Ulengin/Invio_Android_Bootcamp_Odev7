package com.example.iab_odev7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.iab_odev7.data.repo.IslerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KayitViewModel@Inject constructor(var irepo:IslerRepository) : ViewModel() {
    fun kaydet(yapilacak_is:String){
        CoroutineScope(Dispatchers.Main).launch {
            irepo.kaydet(yapilacak_is)
        }
    }
}