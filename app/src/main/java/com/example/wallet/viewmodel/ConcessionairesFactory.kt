package com.example.wallet.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wallet.repositories.ConcessionairesRepository


class ConcessionairesFactory constructor(
    private val concessionairesRepository: ConcessionairesRepository,
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ConcessionairesViewModel::class.java)) {
            ConcessionairesViewModel(
                concessionairesRepository
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel não encontrado!")
        }
    }
}