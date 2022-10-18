package com.example.hammersystemstesttask.domain.usecases

import com.example.hammersystemstesttask.R
import com.example.hammersystemstesttask.domain.ViewPagerPromoAdapter

class GetViewPagerPromosAdapterUseCase {

    fun getAdapter() = ViewPagerPromoAdapter(
        listOf(
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3,
            R.drawable.banner4))
}