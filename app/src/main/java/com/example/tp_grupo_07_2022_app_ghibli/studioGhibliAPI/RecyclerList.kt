package com.example.tp_grupo_07_2022_app_ghibli.studioGhibliAPI

data class RecyclerList (val items :ArrayList<RecyclerData>)

data class RecyclerData(val title: String, val director: String, val release_date: String,val image: String)

