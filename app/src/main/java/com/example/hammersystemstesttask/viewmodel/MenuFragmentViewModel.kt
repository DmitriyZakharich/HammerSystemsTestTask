package com.example.hammersystemstesttask.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hammersystemstesttask.domain.GetAdapterUseCase
import com.example.hammersystemstesttask.domain.RecyclerMenuAdapter

class MenuFragmentViewModel(private val getAdapterUseCase: GetAdapterUseCase) : ViewModel() {

    private var _adapter = MutableLiveData<RecyclerMenuAdapter>()
    val adapter: LiveData<RecyclerMenuAdapter> = _adapter

    init {
        Log.d(TAG, "MenuFragmentViewModel: init")
    }

    fun getAdapter() {
        Log.d(TAG, "MenuFragmentViewModel: getAdapter")

        getAdapterUseCase.adapter.observeForever {
            _adapter.value = it
        }
        getAdapterUseCase.start()
    }
}

const val TAG = "3231321312"