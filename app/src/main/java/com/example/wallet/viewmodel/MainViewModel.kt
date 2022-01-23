package com.example.wallet.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.wallet.R
import com.example.wallet.models.Card
import com.example.wallet.models.Descontos
import com.example.wallet.models.Ofertas
import com.example.wallet.models.Transaction
import com.example.wallet.repositories.CardsRepository
import com.example.wallet.repositories.DescontosRepository
import com.example.wallet.repositories.OfertasRepository
import com.example.wallet.repositories.TransactionsRepository
import com.example.wallet.view.home.HomeFragment


class MainViewModel constructor(
    private val transactionsRepository: TransactionsRepository,
    private val cardsRepository: CardsRepository,
    private val descontosRepository: DescontosRepository,
    private val ofertasRepository: OfertasRepository
) : ViewModel() {
    val liveListTransactions = MutableLiveData<MutableList<Transaction>>()
    val liveListCards = MutableLiveData<MutableList<Card>>()
    val liveListDescontos = MutableLiveData<MutableList<Descontos>>()
    val liveListOfertas = MutableLiveData<MutableList<Ofertas>>()


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

    fun selectedCard(position: Int) {
        selectTransaction = position
        requestTransactions()
    }

    fun requestDescontos() {
        val descontos = descontosRepository.getDescontos()
        liveListDescontos.postValue(descontos)
    }

    fun requestOfertas() {
        val ofertas = ofertasRepository.getOfertas()
        liveListOfertas.postValue(ofertas)
    }

    fun requestNavControllerToCardInfo(){
        findNavController(HomeFragment()).navigate(R.id.action_home_to_cardInfoFragment)
    }
}