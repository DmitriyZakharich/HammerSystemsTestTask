package com.example.hammersystemstesttask.domain

import com.example.hammersystemstesttask.repository.MealRepos

fun mapperReposModelToDomainModel(listRepos: List<MealRepos>): List<MealDomain> {
    val listDomain = mutableListOf<MealDomain>()
    listRepos.forEach{
        listDomain.add(MealDomain(
            idMeal = it.idMeal,
            strMeal = it.strMeal,
            strMealThumb = it.strMealThumb))
    }
    return listDomain
}