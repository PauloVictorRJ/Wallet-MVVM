package com.example.wallet.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wallet.repositories.DescontosRepository
import com.example.wallet.repositories.OfertasRepository


class CardInfoViewModelFactory constructor(
    private val descontosRepository: DescontosRepository,
    private val ofertasRepository: OfertasRepository
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CardInfoViewModel::class.java)) {
            CardInfoViewModel(
                descontosRepository, ofertasRepository
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel não encontrado!")
        }
    }
}
