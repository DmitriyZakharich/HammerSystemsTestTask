package com.example.hammersystemstesttask.di

import com.example.hammersystemstesttask.domain.GetAdapterUseCase
import com.example.hammersystemstesttask.repository.Repository
import com.example.hammersystemstesttask.viewmodel.MenuFragmentViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModel {

    @Provides
    fun provideMenuFragmentViewModelFactory(
            getAdapterUseCase: GetAdapterUseCase): MenuFragmentViewModelFactory =
        MenuFragmentViewModelFactory(getAdapterUseCase)

    @Provides
    fun provideGetAdapterUseCase(
            repository: Repository): GetAdapterUseCase =
        GetAdapterUseCase(repository)

    @Provides
    fun provideNetworkRepository(): Repository = Repository()
}