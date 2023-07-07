package com.hasanaltunbay.notlarmapp.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hasanaltunbay.notlarmapp.R
import com.hasanaltunbay.notlarmapp.databinding.NotCardTasarimBinding
import com.hasanaltunbay.notlarmapp.db.Notlar
import com.hasanaltunbay.notlarmapp.mvvm.NotlarViewModel

class NotlarAdapter(var notlarList:List<Notlar>):RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val layoutInflater=LayoutInflater.from(parent.context)
        val binding:NotCardTasarimBinding=DataBindingUtil.inflate(layoutInflater,R.layout.not_card_tasarim,parent,false)

        return MyHolder(binding)

    }

    override fun getItemCount(): Int {

        return notlarList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.bindTheView(notlarList[position])
    }

}

class MyHolder(val binding:NotCardTasarimBinding):RecyclerView.ViewHolder(binding.root){


    fun bindTheView(notlar:Notlar){
        binding.notBaslik.text=notlar.notbaslik
        binding.notAltBaslik.text=notlar.notaltbaslik

        binding.listItemLayout.setOnClickListener {

            val bundle=Bundle()

            bundle.putString("notbaslik",notlar.notbaslik)
            bundle.putString("notaltbaslik",notlar.notaltbaslik)
            bundle.putString("notgir",notlar.notgir)
            bundle.putString("id",notlar.notid.toString())

            Navigation.findNavController(it).navigate(R.id.action_anaFragment_to_duzenleFragment,bundle)



        }
    }
}