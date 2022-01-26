package com.example.wallet.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallet.models.Contato
import com.example.wallet.repositories.ContatoRepository


class TransferViewModel constructor(
    private val contatoRepository: ContatoRepository

) : ViewModel() {
    private val _liveListContato = MutableLiveData<MutableList<Contato>>()

    fun liveListContato():LiveData<MutableList<Contato>>{
        return _liveListContato
    }

    fun requestContatos() {
        val contatos = contatoRepository.getContatos()
        _liveListContato.postValue(contatos)
    }
}