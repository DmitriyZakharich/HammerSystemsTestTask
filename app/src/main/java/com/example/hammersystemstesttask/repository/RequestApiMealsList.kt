package com.example.hammersystemstesttask.repository

import retrofit2.Call
import retrofit2.http.GET

interface RequestApiMealsList {
    @GET("filter.php?c=Dessert")
    fun getRequest(): Call<List<MealRepos>>
}