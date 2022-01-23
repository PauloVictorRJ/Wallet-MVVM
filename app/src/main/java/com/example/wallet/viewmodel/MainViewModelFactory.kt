package com.example.wallet.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wallet.repositories.CardsRepository
import com.example.wallet.repositories.DescontosRepository
import com.example.wallet.repositories.OfertasRepository
import com.example.wallet.repositories.TransactionsRepository

class MainViewModelFactory constructor(
    private val transactionsRepository: TransactionsRepository,
    private val cardsRepository: CardsRepository,
    private val descontosRepository: DescontosRepository,
    private val ofertasRepository: OfertasRepository
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(transactionsRepository, cardsRepository, descontosRepository, ofertasRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel não encontrado!")
        }
    }
}