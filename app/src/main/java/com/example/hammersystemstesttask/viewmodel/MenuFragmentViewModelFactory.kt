package com.example.hammersystemstesttask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hammersystemstesttask.domain.GetAdapterUseCase

class MenuFragmentViewModelFactory(private val getAdapterUseCase: GetAdapterUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MenuFragmentViewModel(getAdapterUseCase) as T
    }
}