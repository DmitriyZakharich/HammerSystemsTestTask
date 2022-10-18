package com.example.hammersystemstesttask.domain.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.hammersystemstesttask.domain.RecyclerCategoriesAdapter
import com.example.hammersystemstesttask.domain.Repository
import com.example.hammersystemstesttask.domain.mapperCategoriesReposToCategoriesDomain
import com.example.hammersystemstesttask.repository.CategoriesRepos

class GetRecyclerCategoriesAdapterUseCase(private val repository: Repository) {

    private var _adapter: MutableLiveData<RecyclerCategoriesAdapter> = MutableLiveData()
    var adapter: LiveData<RecyclerCategoriesAdapter> = _adapter
    private lateinit var onItemClick : (categoryRequest: String) -> Unit

    fun getAdapterLD(onItemClick: (categoryRequest: String) -> Unit) : LiveData<RecyclerCategoriesAdapter> {
        this.onItemClick = onItemClick
        return _adapter
    }

    init {
        repository.categories.observeForever(observer())
    }

    private fun observer() = Observer<CategoriesRepos> { data ->
        val categoriesList = mapperCategoriesReposToCategoriesDomain(data.categories)
        _adapter.value = RecyclerCategoriesAdapter(categoriesList, onItemClick)
    }

    fun start() {
        repository.loadCategories()
    }
}