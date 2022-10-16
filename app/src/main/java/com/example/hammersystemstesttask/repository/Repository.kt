package com.example.hammersystemstesttask.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    private val retrofit2 = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    private val requestApiGithubRepos = retrofit2.create(RequestApiData::class.java)

    private val _meals = MutableLiveData<MealsRepos>()
    val meals: LiveData<MealsRepos> = _meals

    fun loadMeals() {
        val call = requestApiGithubRepos.getRequest("Beef")

        call.enqueue(object : Callback<MealsRepos> {
            override fun onFailure(call: Call<MealsRepos>, t: Throwable) {}

            override fun onResponse(call: Call<MealsRepos>, response: Response<MealsRepos>) {
                _meals.value = response.body()
            }
        })
    }
}