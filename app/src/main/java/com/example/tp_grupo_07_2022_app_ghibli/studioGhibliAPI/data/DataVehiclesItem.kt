package com.example.tp_grupo_07_2022_app_ghibli.studioGhibliAPI.data

data class DataVehiclesItem(
    val description: String,
    val films: List<String>,
    val id: String,
    val length: String,
    val name: String,
    val pilot: String,
    val url: String,
    val vehicle_class: String
)