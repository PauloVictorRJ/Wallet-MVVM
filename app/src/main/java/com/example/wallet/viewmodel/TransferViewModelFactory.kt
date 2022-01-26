package com.example.wallet.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wallet.repositories.ContatoRepository

class TransferViewModelFactory constructor(
    private val contatoRepository: ContatoRepository,
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(TransferViewModel::class.java)) {
            TransferViewModel(contatoRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel não encontrado!")
        }
    }
}
