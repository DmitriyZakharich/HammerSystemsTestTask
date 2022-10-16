package com.example.hammersystemstesttask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hammersystemstesttask.ViewPagerPromoAdapter
import com.example.hammersystemstesttask.domain.RecyclerMenuAdapter
import com.example.hammersystemstesttask.domain.usecases.GetRecyclerMenuAdapterUseCase
import com.example.hammersystemstesttask.domain.usecases.GetViewPagerPromosAdapterUseCase

class MenuFragmentViewModel(
        private val getRecyclerMenuAdapterUseCase: GetRecyclerMenuAdapterUseCase,
        private val getViewPagerPromosAdapterUseCase: GetViewPagerPromosAdapterUseCase) :
    ViewModel() {

    private var _recyclerMenuAdapter = MutableLiveData<RecyclerMenuAdapter>()
    val recyclerMenuAdapter: LiveData<RecyclerMenuAdapter> = _recyclerMenuAdapter

    private var _viewPagerPromoAdapter = MutableLiveData<ViewPagerPromoAdapter>()
    val viewPagerPromoAdapter: LiveData<ViewPagerPromoAdapter> = _viewPagerPromoAdapter

    fun getRecyclerMenuAdapter() {
        getRecyclerMenuAdapterUseCase.adapter.observeForever {
            _recyclerMenuAdapter.value = it
        }
        getRecyclerMenuAdapterUseCase.start()
    }

    fun getViewPagerPromoAdapter() {
        _viewPagerPromoAdapter.value = getViewPagerPromosAdapterUseCase.getAdapter()
    }
}