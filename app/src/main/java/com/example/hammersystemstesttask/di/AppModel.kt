package com.example.hammersystemstesttask.di

import com.example.hammersystemstesttask.domain.usecases.GetRecyclerMenuAdapterUseCase
import com.example.hammersystemstesttask.domain.usecases.GetViewPagerPromosAdapterUseCase
import com.example.hammersystemstesttask.repository.Repository
import com.example.hammersystemstesttask.viewmodel.MenuFragmentViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModel {

    @Provides
    fun provideMenuFragmentViewModelFactory(
            getRecyclerMenuAdapterUseCase: GetRecyclerMenuAdapterUseCase,
            getViewPagerPromosAdapterUseCase: GetViewPagerPromosAdapterUseCase): MenuFragmentViewModelFactory =
        MenuFragmentViewModelFactory(getRecyclerMenuAdapterUseCase, getViewPagerPromosAdapterUseCase)

    @Provides
    fun provideGetRecyclerMenuAdapterUseCase(repository: Repository): GetRecyclerMenuAdapterUseCase =
        GetRecyclerMenuAdapterUseCase(repository)

    @Provides
    fun provideGetViewPagerPromosAdapterUseCase(): GetViewPagerPromosAdapterUseCase =
        GetViewPagerPromosAdapterUseCase()

    @Provides
    fun provideNetworkRepository(): Repository = Repository()
}