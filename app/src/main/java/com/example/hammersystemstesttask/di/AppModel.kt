package com.example.hammersystemstesttask.di

import com.example.hammersystemstesttask.domain.Repository
import com.example.hammersystemstesttask.domain.usecases.GetRecyclerCategoriesAdapterUseCase
import com.example.hammersystemstesttask.domain.usecases.GetRecyclerMenuAdapterUseCase
import com.example.hammersystemstesttask.domain.usecases.GetViewPagerPromosAdapterUseCase
import com.example.hammersystemstesttask.repository.RepositoryImpl
import com.example.hammersystemstesttask.viewmodel.MenuFragmentViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModel {

    @Provides
    fun provideMenuFragmentViewModelFactory(
            getRecyclerMenuAdapterUseCase: GetRecyclerMenuAdapterUseCase,
            getViewPagerPromosAdapterUseCase: GetViewPagerPromosAdapterUseCase,
    getRecyclerCategoriesAdapterUseCase: GetRecyclerCategoriesAdapterUseCase): MenuFragmentViewModelFactory =
        MenuFragmentViewModelFactory(getRecyclerMenuAdapterUseCase, getViewPagerPromosAdapterUseCase, getRecyclerCategoriesAdapterUseCase)

    @Provides
    fun provideGetRecyclerMenuAdapterUseCase(repository: Repository): GetRecyclerMenuAdapterUseCase =
        GetRecyclerMenuAdapterUseCase(repository)

    @Provides
    fun provideGetRecyclerCategoriesAdapterUseCase(repository: Repository): GetRecyclerCategoriesAdapterUseCase =
        GetRecyclerCategoriesAdapterUseCase(repository)

    @Provides
    fun provideGetViewPagerPromosAdapterUseCase(): GetViewPagerPromosAdapterUseCase =
        GetViewPagerPromosAdapterUseCase()

    @Provides
    fun provideNetworkRepository(): Repository = RepositoryImpl()
}