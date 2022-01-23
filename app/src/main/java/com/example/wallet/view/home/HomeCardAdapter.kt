package com.example.wallet.view.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.wallet.models.Card


class HomeCardAdapter(fragment: Fragment, private val action: () -> Unit) : FragmentStateAdapter(fragment) {
    private val listCards = mutableListOf<Card>()
    lateinit var cartaoAtual:Card

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

    override fun onBindViewHolder(
        holder: FragmentViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
        holder.itemView.setOnClickListener {
            cartaoAtual = listCards[position]
            action.invoke()

        }
    }

    fun setListCards(listRx: MutableList<Card>) {
        listCards.addAll(listRx)
        notifyDataSetChanged()
    }

}

