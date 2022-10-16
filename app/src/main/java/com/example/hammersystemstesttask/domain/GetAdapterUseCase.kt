package com.example.hammersystemstesttask.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.hammersystemstesttask.repository.MealsRepos
import com.example.hammersystemstesttask.repository.Repository

class GetAdapterUseCase(private val repository: Repository) {

    private var _adapter: MutableLiveData<RecyclerMenuAdapter> = MutableLiveData()
    var adapter: LiveData<RecyclerMenuAdapter> = _adapter

    init {
        repository.meals.observeForever(observer())
    }

    private fun observer() = Observer<MealsRepos> { data ->
        val mealsList = mapperReposModelToDomainModel(data.meals)
        _adapter.value = RecyclerMenuAdapter(mealsList)
    }

    fun start() {
        repository.loadMeals()
    }
}