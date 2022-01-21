package com.example.wallet.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallet.models.Card
import com.example.wallet.models.Transaction
import com.example.wallet.repositories.CardsRepository
import com.example.wallet.repositories.TransactionsRepository


class HomeViewModel constructor(
    private val transactionsRepository: TransactionsRepository,
    private val cardsRepository: CardsRepository
) : ViewModel() {
    val liveListTransactions = MutableLiveData<MutableList<Transaction>>()
    val liveListCards = MutableLiveData<MutableList<Card>>()

    fun requestTransactions() {
        val transaction1 = transactionsRepository.getTransactions1()
        liveListTransactions.postValue(transaction1)
        val transaction2 = transactionsRepository.getTransactions2()
        val transaction3 = transactionsRepository.getTransactions3()
        val transaction4 = transactionsRepository.getTransactions4()
        val transaction5 = transactionsRepository.getTransactions5()
    }

    fun requestCards() {
        val cards = cardsRepository.getCards()
        liveListCards.postValue(cards)

    }

}