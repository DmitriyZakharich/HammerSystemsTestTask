package com.example.hammersystemstesttask.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestApiData {
    @GET("filter.php")
    fun getRequest(@Query("c") c: String): Call<MealsRepos>
}