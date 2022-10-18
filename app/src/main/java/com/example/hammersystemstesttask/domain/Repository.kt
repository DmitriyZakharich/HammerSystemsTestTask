package com.example.hammersystemstesttask.domain

import androidx.lifecycle.LiveData
import com.example.hammersystemstesttask.repository.CategoriesRepos
import com.example.hammersystemstesttask.repository.MealsRepos

interface Repository {
    val meals: LiveData<MealsRepos>
    val categories: LiveData<CategoriesRepos>
    fun loadMeals(categoryRequest: String)
    fun loadCategories()
}