package com.example.tp_grupo_07_2022_app_ghibli.studioGhibliAPI

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryName

interface GhibliAPI {

        @GET("films")
        suspend fun getDataFromApi(@Query("q") query : String): RecyclerList



}
