package com.example.wallet.viewmodel

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallet.models.Contato
import com.example.wallet.repositories.ContatoRepository
import com.example.wallet.util.PrintScreen
import com.example.wallet.util.SaveAndShare
import com.example.wallet.view.transfer.TransferFragment


class TransferViewModel constructor(private val contatoRepository: ContatoRepository) : ViewModel() {

    private val _liveListContato = MutableLiveData<MutableList<Contato>>()

    fun liveListContato(): LiveData<MutableList<Contato>> {
        return _liveListContato
    }

    fun requestContatos() {
        val contatos = contatoRepository.getContatos()
        _liveListContato.postValue(contatos)
    }

    fun PrintScreen(view: View, activity: Activity) {
        val permissionCamera =
            ContextCompat.checkSelfPermission(view.context, Manifest.permission.CAMERA)

        val permissionWriteExt =
            ContextCompat.checkSelfPermission(
                view.context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )

        val permissionReadExt =
            ContextCompat.checkSelfPermission(
                view.context,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )

        if (permissionCamera != PackageManager.PERMISSION_GRANTED) {
            TransferFragment().permissionsResultCallback.launch(Manifest.permission.CAMERA)
        } else if (permissionWriteExt != PackageManager.PERMISSION_GRANTED) {
            TransferFragment().permissionsResultCallback.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        } else if (permissionReadExt != PackageManager.PERMISSION_GRANTED) {
            TransferFragment().permissionsResultCallback.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        } else {
            var bitmapScreen = PrintScreen().printScreen(view)
            if (bitmapScreen != null) {
                SaveAndShare(activity, bitmapScreen).saveAndShare()
            }
        }
    }
}