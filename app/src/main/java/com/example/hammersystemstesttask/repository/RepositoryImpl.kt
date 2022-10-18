package com.example.hammersystemstesttask.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hammersystemstesttask.domain.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryImpl : Repository {

    private val retrofit2 = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    private val requestApiGithubRepos = retrofit2.create(RequestApiData::class.java)

    private val _meals = MutableLiveData<MealsRepos>()
    override val meals: LiveData<MealsRepos> = _meals

    private val _categories = MutableLiveData<CategoriesRepos>()
    override val categories: LiveData<CategoriesRepos> = _categories

    override fun loadMeals(categoryRequest: String) {
        val call = requestApiGithubRepos.getRequestMeals(categoryRequest)

        call.enqueue(object : Callback<MealsRepos> {
            override fun onFailure(call: Call<MealsRepos>, t: Throwable) {}

            override fun onResponse(call: Call<MealsRepos>, response: Response<MealsRepos>) {
                _meals.value = response.body()
            }
        })
    }

    override fun loadCategories() {
        val call = requestApiGithubRepos.getRequestCategories()

        call.enqueue(object : Callback<CategoriesRepos> {
            override fun onFailure(call: Call<CategoriesRepos>, t: Throwable) {}

            override fun onResponse(call: Call<CategoriesRepos>, response: Response<CategoriesRepos>) {
                _categories.value = response.body()
            }
        })
    }
}