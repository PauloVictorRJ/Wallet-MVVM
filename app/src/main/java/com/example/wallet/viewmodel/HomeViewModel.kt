package com.example.wallet.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallet.models.Transaction
import com.example.wallet.repositories.TransactionsRepository


class HomeViewModel constructor(private val transactionsRepository :TransactionsRepository) : ViewModel() {
        val liveList = MutableLiveData<MutableList<Transaction>>()

    fun request(){
        val transaction1 = transactionsRepository.getTransactions1()
        liveList.postValue(transaction1)
        val transaction2 = transactionsRepository.getTransactions2()
        val transaction3 = transactionsRepository.getTransactions3()
        val transaction4 = transactionsRepository.getTransactions4()
        val transaction5 = transactionsRepository.getTransactions5()
    }

}