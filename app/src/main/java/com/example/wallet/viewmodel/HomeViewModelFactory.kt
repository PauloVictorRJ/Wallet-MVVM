package com.example.wallet.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wallet.repositories.*


class HomeViewModelFactory constructor(
    private val transactionsRepository: TransactionsRepository,
    private val cardsRepository: CardsRepository,
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(
                transactionsRepository, cardsRepository,
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel não encontrado!")
        }
    }
}