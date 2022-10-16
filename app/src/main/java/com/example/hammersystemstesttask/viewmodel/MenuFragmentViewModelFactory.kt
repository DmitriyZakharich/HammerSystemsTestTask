package com.example.hammersystemstesttask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hammersystemstesttask.domain.usecases.GetRecyclerMenuAdapterUseCase
import com.example.hammersystemstesttask.domain.usecases.GetViewPagerPromosAdapterUseCase

class MenuFragmentViewModelFactory(
        private val getRecyclerMenuAdapterUseCase: GetRecyclerMenuAdapterUseCase,
        private val getViewPagerPromosAdapterUseCase: GetViewPagerPromosAdapterUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MenuFragmentViewModel(getRecyclerMenuAdapterUseCase,
            getViewPagerPromosAdapterUseCase) as T
    }
}