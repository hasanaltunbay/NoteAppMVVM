package com.hasanaltunbay.notlarmapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.hasanaltunbay.notlarmapp.R
import com.hasanaltunbay.notlarmapp.databinding.FragmentAnaBinding
import com.hasanaltunbay.notlarmapp.db.Notlar
import com.hasanaltunbay.notlarmapp.db.NotlarDatabase
import com.hasanaltunbay.notlarmapp.mvvm.NotlarFactoryViewMode
import com.hasanaltunbay.notlarmapp.mvvm.NotlarRepository
import com.hasanaltunbay.notlarmapp.mvvm.NotlarViewModel
import com.hasanaltunbay.notlarmapp.ui.adapter.NotlarAdapter


class AnaFragment : Fragment(){

    lateinit var binding:FragmentAnaBinding
    lateinit var viewModel:NotlarViewModel
    lateinit var adapter:NotlarAdapter
    var dummyList= listOf<Notlar>()
    var aranotlar= listOf<Notlar>()


    @Suppress("DEPRECATION")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_ana,container,false)

        binding.toolbar.setTitle("Notlarim")

        val dao= NotlarDatabase.getInstance(requireContext()).notlarDao
        val repository= NotlarRepository(dao)
        val factory= NotlarFactoryViewMode(repository)

        viewModel= ViewModelProvider(this,factory)[NotlarViewModel::class.java]

        adapter= NotlarAdapter(dummyList)

        binding.recyclerView.layoutManager=GridLayoutManager(context,1)

        viewModel.displayTumNotlar.observe(viewLifecycleOwner, Observer {


            aranotlar=it as ArrayList<Notlar>

            adapter= NotlarAdapter(it)

            binding.recyclerView.adapter=adapter

        })

        binding.fab.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_anaFragment_to_kaydetFragment)

        }
        return binding.root

    }
}