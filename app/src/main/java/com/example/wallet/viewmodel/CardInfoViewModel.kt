package com.example.wallet.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallet.models.Descontos
import com.example.wallet.models.Ofertas
import com.example.wallet.repositories.DescontosRepository
import com.example.wallet.repositories.OfertasRepository


class CardInfoViewModel constructor(
    private val descontosRepository: DescontosRepository,
    private val ofertasRepository: OfertasRepository,
) : ViewModel() {
    private val _liveListDescontos = MutableLiveData<MutableList<Descontos>>()
    private val _liveListOfertas = MutableLiveData<MutableList<Ofertas>>()

    fun liveListDescontos(): LiveData<MutableList<Descontos>> {
        return _liveListDescontos
    }

    fun liveListOfertas(): LiveData<MutableList<Ofertas>> {
        return _liveListOfertas
    }

    fun requestDescontos() {
        val descontos = descontosRepository.getDescontos()
        _liveListDescontos.postValue(descontos)
    }

    fun requestOfertas() {
        val ofertas = ofertasRepository.getOfertas()
        _liveListOfertas.postValue(ofertas)
    }
}
