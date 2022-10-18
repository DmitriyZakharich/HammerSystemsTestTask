package com.example.hammersystemstesttask.repository

data class MealsRepos(
    val meals: List<MealRepos>
)

data class MealRepos(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
)

data class CategoriesRepos(
    val categories: List<CategoryRepos>
)

data class CategoryRepos(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)