package com.example.wallet.viewmodel

import android.app.Activity
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallet.models.Contato
import com.example.wallet.repositories.ContatoRepository
import com.example.wallet.util.PrintScreen
import com.example.wallet.util.SaveFile
import kotlinx.coroutines.NonDisposableHandle.parent


class TransferViewModel constructor(
    private val contatoRepository: ContatoRepository

) : ViewModel() {
    private val _liveListContato = MutableLiveData<MutableList<Contato>>()

    fun liveListContato(): LiveData<MutableList<Contato>> {
        return _liveListContato
    }

    fun requestContatos() {
        val contatos = contatoRepository.getContatos()
        _liveListContato.postValue(contatos)
    }

    fun vmPrintScreen(view: View, activity: Activity) {
        PrintScreen().printScreen(view)?.let {
            SaveFile(activity, it).saveAndShare()
        }
    }

}
