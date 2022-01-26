package com.example.wallet.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallet.models.Concessionaires
import com.example.wallet.repositories.ConcessionairesRepository


class ConcessionairesViewModel constructor(
    private val concessionariesRepository: ConcessionairesRepository,
) : ViewModel() {
    private val _liveListConcessionaires = MutableLiveData<MutableList<Concessionaires>>()

    fun liveListConcessionaires(): LiveData<MutableList<Concessionaires>> {
        return _liveListConcessionaires
    }

    fun requestConcessionaires() {
        val concessionaires = ConcessionairesRepository().getConcessionaires()
        _liveListConcessionaires.postValue(concessionaires)
    }
}
