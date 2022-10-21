package com.example.iab_odev7.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.iab_odev7.R
import com.example.iab_odev7.data.entity.Isler
import com.example.iab_odev7.databinding.CardTasarimBinding
import com.example.iab_odev7.ui.fragment.AnasayfaFragmentDirections
import com.example.iab_odev7.ui.viewmodel.AnasayfaViewModel
import com.example.iab_odev7.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class IslerAdapter(var mContext: Context,
                   var islerListesi:List<Isler>,
                   var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<IslerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim ,parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val isler = islerListesi.get(position)
        val x = holder.tasarim
        x.isNesnesi = isler

        x.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.isDetayGecis(work = isler)
            Navigation.gecisYap(it,gecis)
        }

        x.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${isler.yapilacak_is} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.sil(isler.yapilacak_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return islerListesi.size
    }
}