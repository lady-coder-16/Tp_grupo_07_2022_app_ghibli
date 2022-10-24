package com.example.tp_grupo_07_2022_app_ghibli.studioGhibliAPI

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class RetroInstance {
    companion object{
        val BaseURL = "https://ghibliapi.herokuapp.com/"

        fun getRetroInstance(): Retrofit{

            return Retrofit.Builder()
                    .baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
    }
}