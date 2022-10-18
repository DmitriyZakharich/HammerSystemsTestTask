package com.example.hammersystemstesttask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hammersystemstesttask.domain.RecyclerCategoriesAdapter
import com.example.hammersystemstesttask.domain.RecyclerMenuAdapter
import com.example.hammersystemstesttask.domain.ViewPagerPromoAdapter
import com.example.hammersystemstesttask.domain.usecases.GetRecyclerCategoriesAdapterUseCase
import com.example.hammersystemstesttask.domain.usecases.GetRecyclerMenuAdapterUseCase
import com.example.hammersystemstesttask.domain.usecases.GetViewPagerPromosAdapterUseCase
import kotlin.reflect.KFunction1

class MenuFragmentViewModel(
        private val getRecyclerMenuAdapterUseCase: GetRecyclerMenuAdapterUseCase,
        private val getViewPagerPromosAdapterUseCase: GetViewPagerPromosAdapterUseCase,
        private val getRecyclerCategoriesAdapterUseCase: GetRecyclerCategoriesAdapterUseCase) :
    ViewModel() {

    private var _recyclerMenuAdapter = MutableLiveData<RecyclerMenuAdapter>()
    val recyclerMenuAdapter: LiveData<RecyclerMenuAdapter> = _recyclerMenuAdapter

    private var _viewPagerPromoAdapter = MutableLiveData<ViewPagerPromoAdapter>()
    val viewPagerPromoAdapter: LiveData<ViewPagerPromoAdapter> = _viewPagerPromoAdapter

    private var _recyclerCategoriesAdapter = MutableLiveData<RecyclerCategoriesAdapter>()
    val recyclerCategoriesAdapter: LiveData<RecyclerCategoriesAdapter> = _recyclerCategoriesAdapter

    fun getRecyclerMenuAdapter(categoryRequest: String = "Beef") {
        getRecyclerMenuAdapterUseCase.adapter.observeForever {
            _recyclerMenuAdapter.value = it
        }
        getRecyclerMenuAdapterUseCase.start(categoryRequest)
    }

    fun getViewPagerPromoAdapter() {
        _viewPagerPromoAdapter.value = getViewPagerPromosAdapterUseCase.getAdapter()
    }

    fun getRecyclerCategoriesAdapter(onItemClick: (string: String) -> Unit) {

        getRecyclerCategoriesAdapterUseCase.getAdapterLD ( onItemClick ).observeForever{
            _recyclerCategoriesAdapter.value = it
        }
        getRecyclerCategoriesAdapterUseCase.start()
    }
}