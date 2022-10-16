package com.example.hammersystemstesttask.di

import com.example.hammersystemstesttask.menu_screen.MenuFragment
import dagger.Component

@Component(modules = [AppModel::class])
interface AppComponent {
    fun inject(menuFragment: MenuFragment)
}