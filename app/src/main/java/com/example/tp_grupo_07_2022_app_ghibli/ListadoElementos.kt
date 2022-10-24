package com.example.tp_grupo_07_2022_app_ghibli

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class ListadoElementos : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_elementos)

        //esto esta agregado de ahora
        setupFragment()
        //aca termina lo agregado


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            val manager = supportFragmentManager
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragmentListado)!!)
                    .hide(manager.findFragmentById(R.id.fragmentDetalles)!!)
                    .addToBackStack(null)
                    .commit()
        } else {
            val manager = supportFragmentManager
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragmentDetalles)!!)
                    .show(manager.findFragmentById(R.id.fragmentListado)!!)
                    .commit()
        }
    }
 // esto tambien se agrega
    private fun setupFragment(){
        val fragment = FragmentLista.newInstance()
     val fragmentManager: FragmentManager = supportFragmentManager
     val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
     fragmentTransaction.replace(android.R.id.content, fragment)
     fragmentTransaction.commit()
    }
    //fin de lo agregado

}
