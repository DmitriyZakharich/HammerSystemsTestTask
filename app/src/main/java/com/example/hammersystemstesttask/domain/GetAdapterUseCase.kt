package com.example.hammersystemstesttask.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.hammersystemstesttask.repository.MealRepos
import com.example.hammersystemstesttask.repository.Repository
import com.example.hammersystemstesttask.viewmodel.TAG

class GetAdapterUseCase(private val repository: Repository) {

    private var _adapter: MutableLiveData<RecyclerMenuAdapter> = MutableLiveData()
    var adapter: LiveData<RecyclerMenuAdapter> = _adapter

    init {
        Log.d(TAG, "GetAdapterUseCase: init")
        repository.meals.observeForever(observer())
    }

    private fun observer() = Observer<List<MealRepos>> { data ->
        Log.d(TAG, "GetAdapterUseCase: observer")

        val mealsList = mapperReposModelToDomainModel(data)
        _adapter.value = RecyclerMenuAdapter(mealsList)
    }

    fun start() {
        Log.d(TAG, "GetAdapterUseCase: start")

        repository.loadData()
    }
}