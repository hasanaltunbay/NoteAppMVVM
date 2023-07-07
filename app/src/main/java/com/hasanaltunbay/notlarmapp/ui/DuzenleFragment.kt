package com.hasanaltunbay.notlarmapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.hasanaltunbay.notlarmapp.R
import com.hasanaltunbay.notlarmapp.databinding.FragmentDuzenleBinding
import com.hasanaltunbay.notlarmapp.db.Notlar
import com.hasanaltunbay.notlarmapp.db.NotlarDatabase
import com.hasanaltunbay.notlarmapp.mvvm.NotlarFactoryViewMode
import com.hasanaltunbay.notlarmapp.mvvm.NotlarRepository
import com.hasanaltunbay.notlarmapp.mvvm.NotlarViewModel


class DuzenleFragment : Fragment(){

    lateinit var binding:FragmentDuzenleBinding

    lateinit var viewModel:NotlarViewModel

    lateinit var baslik:String
    lateinit var altbaslik:String
    lateinit var notgir:String
    lateinit var id:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_duzenle,container,false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner=viewLifecycleOwner

        val dao= NotlarDatabase.getInstance(requireContext()).notlarDao
        val repository= NotlarRepository(dao)
        val factory= NotlarFactoryViewMode(repository)

        viewModel= ViewModelProvider(this,factory)[NotlarViewModel::class.java]
        binding.viewModel = viewModel

        baslik=requireArguments().getString("notbaslik").toString()
        altbaslik=requireArguments().getString("notaltbaslik").toString()
        notgir=requireArguments().getString("notgir").toString()
        id=requireArguments().getString("id").toString()

        binding.BaslikEdittext.setText(baslik)
        binding.altBaslikEdittext.setText(altbaslik)
        binding.notGirEdittext.setText(notgir)

        binding.butonGuncelle.setOnClickListener {

            val yeniId=id.toInt()
            val yeniBaslik=binding.BaslikEdittext.text
            val yeniAltBaslik=binding.altBaslikEdittext.text
            val yeniNotGir=binding.notGirEdittext.text

            viewModel.duzenleNot(yeniId,
                yeniBaslik.toString(),
                yeniAltBaslik.toString(),
                yeniNotGir.toString())

            view.findNavController().navigate(R.id.action_duzenleFragment_to_anaFragment)
        }

        binding.butonSil.setOnClickListener {

            val yeniId=id.toInt()
            val yeniBaslik=binding.BaslikEdittext.text
            val yeniAltBaslik=binding.altBaslikEdittext.text
            val yeniNotGir=binding.notGirEdittext.text

            viewModel.silNot(Notlar(yeniId,
                yeniBaslik.toString(),
                yeniAltBaslik.toString(),
                yeniNotGir.toString()))


            view.findNavController().navigate(R.id.action_duzenleFragment_to_anaFragment)
        }

    }

}