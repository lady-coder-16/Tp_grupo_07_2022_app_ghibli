package com.example.tp_grupo_07_2022_app_ghibli

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_grupo_07_2022_app_ghibli.adapter.RecyclerViewAdapter
import com.example.tp_grupo_07_2022_app_ghibli.studioGhibliAPI.RecyclerList
import com.example.tp_grupo_07_2022_app_ghibli.viewModel.ListadoElementosViewModel


class FragmentLista : Fragment() {

    private lateinit var recyclerAdapter : RecyclerViewAdapter

    override fun onCreateView (inflater: LayoutInflater, container:ViewGroup?,
                               savedInstanceState: Bundle?): View?{
        val view = inflater.inflate(R.layout.fragment_lista,container,false)

        initViewModel(view)
        initViewModel()
        return view
    }

    private fun initViewModel(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_A)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)

        recyclerAdapter= RecyclerViewAdapter()

        recyclerView.adapter = recyclerAdapter
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(ListadoElementosViewModel::class.java)
        viewModel.getRecyclerListObserver().observe(viewLifecycleOwner) {
            if (it != null) {
                recyclerAdapter.setUpdatedData(it.items)
            } else {
                Toast.makeText(activity, "Error en llegar a la data", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.makeApiCall()
    }


    companion object{
        @JvmStatic
        fun newInstance() =
                FragmentLista()
    }

    }
