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

    private var transactionNumber = 0

    private var _selectedTransaction = mutableListOf<Transaction>()


    fun returnSelectedTransaction(): MutableList<Transaction> {
        return _selectedTransaction
    }

    fun liveListTransactions(): LiveData<MutableList<Transaction>> {
        return _liveListTransactions
    }

    fun liveListCards(): LiveData<MutableList<Card>> {
        return _liveListCards
    }

    fun requestTransactions() {
        if (transactionNumber == 0) {
            _selectedTransaction = transactionsRepository.getTransactions0()
            _liveListTransactions.postValue(_selectedTransaction)
        } else if (transactionNumber == 1) {
            _selectedTransaction = transactionsRepository.getTransactions1()
            _liveListTransactions.postValue(_selectedTransaction)
        } else if (transactionNumber == 2) {
            _selectedTransaction = transactionsRepository.getTransactions2()
            _liveListTransactions.postValue(_selectedTransaction)
        } else if (transactionNumber == 3) {
            val _selectedTransaction = transactionsRepository.getTransactions3()
            _liveListTransactions.postValue(_selectedTransaction)
        } else {
            _selectedTransaction = transactionsRepository.getTransactions4()
            _liveListTransactions.postValue(_selectedTransaction)
        }
    }

    fun requestCards() {
        val cards = cardsRepository.getCards()
        _liveListCards.value = cards
    }

    fun selectedCard(position: Int) {
        transactionNumber = position
        requestTransactions()
    }
}