package com.example.tp_grupo_07_2022_app_ghibli.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp_grupo_07_2022_app_ghibli.studioGhibliAPI.GhibliAPI
import com.example.tp_grupo_07_2022_app_ghibli.studioGhibliAPI.RecyclerList
import com.example.tp_grupo_07_2022_app_ghibli.studioGhibliAPI.RetroInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListadoElementosViewModel: ViewModel() {
    var recyclerListLiveData : MutableLiveData<RecyclerList> = MutableLiveData()

    fun getRecyclerListObserver(): MutableLiveData<RecyclerList>{
        return recyclerListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO){
           val retroInstance = RetroInstance.getRetroInstance().create(GhibliAPI::class.java)
            val response = retroInstance.getDataFromApi("ny")
            recyclerListLiveData.postValue(response)
        }
    }
}