package com.example.wallet.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.wallet.R


class Home : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager2 = view.findViewById<ViewPager2>(R.id.list_card)
        val rvHomeTransacoes: RecyclerView = view.findViewById(R.id.rv_home_transacoes)
    }
}