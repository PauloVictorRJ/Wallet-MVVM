package com.example.wallet.view.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.wallet.models.Card


class HomeCardAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val listCards = mutableListOf<Card>()

    fun setListCards(listRx: MutableList<Card>) {
        listCards.addAll(listRx)
        notifyDataSetChanged()
    }

    override fun getItemCount() = listCards.size

    override fun createFragment(position: Int): Fragment {
        if (listCards.isEmpty()) {
            throw IllegalStateException("Items are empty")
        }

        return listCards[position].run {
            HomeCardItemFragment.newInstance(
                limite, bandeira, numero, nome, validade, background
            )
        }
    }
}

