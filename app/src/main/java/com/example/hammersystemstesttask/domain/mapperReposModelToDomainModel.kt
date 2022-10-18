package com.example.hammersystemstesttask.domain

import com.example.hammersystemstesttask.repository.CategoryRepos
import com.example.hammersystemstesttask.repository.MealRepos

fun mapperMealsReposToMealsDomain(list: List<MealRepos>): List<MealDomain> {
    val listDomain = mutableListOf<MealDomain>()
    list.forEach{
        listDomain.add(MealDomain(
            idMeal = it.idMeal,
            strMeal = it.strMeal,
            strMealThumb = it.strMealThumb))
    }
    return listDomain
}

fun mapperCategoriesReposToCategoriesDomain(list: List<CategoryRepos>): List<CategoryDomain> {
    val listDomain = mutableListOf<CategoryDomain>()
    list.forEach{
        listDomain.add(CategoryDomain(
            idCategory = it.idCategory,
            strCategory = it.strCategory,
            strCategoryDescription = it.strCategoryDescription,
            strCategoryThumb = it.strCategoryThumb))
    }
    return listDomain
}