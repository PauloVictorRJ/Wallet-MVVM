package com.example.wallet.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallet.models.*
import com.example.wallet.repositories.*


class HomeViewModel constructor(
    private val transactionsRepository: TransactionsRepository,
    private val cardsRepository: CardsRepository,
) : ViewModel() {
    private val _liveListTransactions = MutableLiveData<MutableList<Transaction>>()
    private val _liveListCards = MutableLiveData<MutableList<Card>>()

    private var selectTransaction = 0

    fun liveListTransactions(): LiveData<MutableList<Transaction>> {
        return _liveListTransactions
    }

    fun liveListCards(): LiveData<MutableList<Card>> {
        return _liveListCards
    }

    fun requestTransactions() {
        if (selectTransaction == 0) {
            val transaction0 = transactionsRepository.getTransactions0()
            _liveListTransactions.postValue(transaction0)
        } else if (selectTransaction == 1) {
            val transaction1 = transactionsRepository.getTransactions1()
            _liveListTransactions.postValue(transaction1)
        } else if (selectTransaction == 2) {
            val transaction2 = transactionsRepository.getTransactions2()
            _liveListTransactions.postValue(transaction2)
        } else if (selectTransaction == 3) {
            val transaction3 = transactionsRepository.getTransactions3()
            _liveListTransactions.postValue(transaction3)
        } else {
            val transaction4 = transactionsRepository.getTransactions4()
            _liveListTransactions.postValue(transaction4)
        }
    }

    fun requestCards() {
        val cards = cardsRepository.getCards()
        _liveListCards.value = cards
    }

    fun selectedCard(position: Int) {
        selectTransaction = position
        requestTransactions()
    }
}