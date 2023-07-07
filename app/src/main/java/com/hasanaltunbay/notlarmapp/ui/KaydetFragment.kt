package com.hasanaltunbay.notlarmapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.hasanaltunbay.notlarmapp.R
import com.hasanaltunbay.notlarmapp.databinding.FragmentKaydetBinding
import com.hasanaltunbay.notlarmapp.db.NotlarDatabase
import com.hasanaltunbay.notlarmapp.mvvm.NotlarFactoryViewMode
import com.hasanaltunbay.notlarmapp.mvvm.NotlarRepository
import com.hasanaltunbay.notlarmapp.mvvm.NotlarViewModel


class KaydetFragment : Fragment() {

    lateinit var binding:FragmentKaydetBinding
    lateinit var viewModel:NotlarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_kaydet,container,false)



        val dao=NotlarDatabase.getInstance(requireContext()).notlarDao
        val repository=NotlarRepository(dao)
        val factory=NotlarFactoryViewMode(repository)

        viewModel=ViewModelProvider(this,factory)[NotlarViewModel::class.java]

        binding.viewModel=viewModel
        binding.lifecycleOwner=this

        binding.buttonKaydet.setOnClickListener {

            viewModel.ekleNot()
            view?.findNavController()?.navigate(R.id.action_kaydetFragment_to_anaFragment)

        }

        return binding.root
    }

}