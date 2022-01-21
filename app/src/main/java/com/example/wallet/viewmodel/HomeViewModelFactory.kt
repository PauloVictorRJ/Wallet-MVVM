package com.example.wallet.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wallet.repositories.CardsRepository
import com.example.wallet.repositories.TransactionsRepository

class HomeViewModelFactory constructor(
    private val transactionsRepository: TransactionsRepository,
    private val cardsRepository: CardsRepository
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(this.transactionsRepository, this.cardsRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel não encontrado!")
        }
    }
}