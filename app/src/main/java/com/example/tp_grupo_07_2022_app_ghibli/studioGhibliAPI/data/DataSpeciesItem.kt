package com.example.tp_grupo_07_2022_app_ghibli.studioGhibliAPI.data

data class DataSpeciesItem(
    val classification: String,
    val eye_colors: String,
    val films: List<String>,
    val hair_colors: String,
    val id: String,
    val name: String,
    val people: List<String>,
    val url: String
)