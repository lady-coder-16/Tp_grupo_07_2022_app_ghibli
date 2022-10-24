package com.example.tp_grupo_07_2022_app_ghibli.studioGhibliAPI.data

data class DataLocationsItem(
    val climate: String,
    val films: List<String>,
    val id: String,
    val name: String,
    val residents: List<String>,
    val surface_water: String,
    val terrain: String,
    val url: String
)