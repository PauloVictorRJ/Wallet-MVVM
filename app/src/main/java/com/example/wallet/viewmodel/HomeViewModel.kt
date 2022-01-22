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

    var selectTransaction = 0

    fun requestTransactions() {
        if (selectTransaction == 0) {
            val transaction0 = transactionsRepository.getTransactions0()
            liveListTransactions.postValue(transaction0)
        } else if (selectTransaction == 1) {
            val transaction1 = transactionsRepository.getTransactions1()
            liveListTransactions.postValue(transaction1)
        } else if (selectTransaction == 2) {
            val transaction2 = transactionsRepository.getTransactions2()
            liveListTransactions.postValue(transaction2)
        } else if (selectTransaction == 3) {
            val transaction3 = transactionsRepository.getTransactions3()
            liveListTransactions.postValue(transaction3)
        } else {
            val transaction4 = transactionsRepository.getTransactions4()
            liveListTransactions.postValue(transaction4)
        }
    }

    fun requestCards() {
        val cards = cardsRepository.getCards()
        liveListCards.postValue(cards)

    }

    fun selectedCard (position:Int){
        selectTransaction = position
        requestTransactions()


    }

    fun refreshTransactionsList() {}

}