package com.example.hammersystemstesttask.domain.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.hammersystemstesttask.domain.RecyclerMenuAdapter
import com.example.hammersystemstesttask.domain.Repository
import com.example.hammersystemstesttask.domain.mapperMealsReposToMealsDomain
import com.example.hammersystemstesttask.repository.MealsRepos

class GetRecyclerMenuAdapterUseCase(private val repository: Repository) {

    private var _adapter: MutableLiveData<RecyclerMenuAdapter> = MutableLiveData()
    var adapter: LiveData<RecyclerMenuAdapter> = _adapter

    init {
        repository.meals.observeForever(observer())
    }

    private fun observer() = Observer<MealsRepos> { data ->
        val mealsList = mapperMealsReposToMealsDomain(data.meals)
        _adapter.value = RecyclerMenuAdapter(mealsList)
    }

    fun start(categoryRequest: String) {
        repository.loadMeals(categoryRequest)
    }
}