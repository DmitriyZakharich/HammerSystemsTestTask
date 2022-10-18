package com.example.hammersystemstesttask.domain

data class MealDomain(
        val idMeal: String,
        val strMeal: String,
        val strMealThumb: String
)

data class CategoryDomain(
        val idCategory: String,
        val strCategory: String,
        val strCategoryDescription: String,
        val strCategoryThumb: String
)