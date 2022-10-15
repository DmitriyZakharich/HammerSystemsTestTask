package com.example.hammersystemstesttask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hammersystemstesttask.viewmodel.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val _meals = MutableLiveData<List<MealRepos>>()
    val meals: LiveData<List<MealRepos>> = _meals


    fun loadData() {
        Log.d(TAG, "Repository: loadData")

        val requestApiGithubRepos = retrofit.create(RequestApiMealsList::class.java)
        val call = requestApiGithubRepos.getRequest()

        call.enqueue(object : Callback<List<MealRepos>> {
            override fun onFailure(call: Call<List<MealRepos>>, t: Throwable) {
                Log.d(TAG, "Repository: onFailure")
            }

            override fun onResponse(call: Call<List<MealRepos>>, response: Response<List<MealRepos>>) {
                if (response.isSuccessful) _meals.value = response.body()
                Log.d(TAG, "Repository: onResponse")

            }
        })
    }
}