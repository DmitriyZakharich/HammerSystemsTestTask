package com.example.hammersystemstesttask.empty_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hammersystemstesttask.R

class BasketFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_basket, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = BasketFragment()
    }
}