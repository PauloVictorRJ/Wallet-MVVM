package com.example.wallet.util

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import com.example.wallet.BuildConfig
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class SaveAndShare(private val activity: Activity, private val bitmap: Bitmap) {
    val filmename = "${System.currentTimeMillis()}.jpg"
    var fos: OutputStream? = null
    var uri: Uri? = null

    fun saveAndShare() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            activity.contentResolver?.also { resolver ->
                val contentValues = ContentValues().apply {
                    put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
                    put(MediaStore.MediaColumns.DISPLAY_NAME, filmename)
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
                }
                val imageUri =
                    resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
                uri = imageUri
                fos = imageUri?.let { resolver.openOutputStream(it) }
            }
        } else {
            val imageDir =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            val image = File(imageDir, filmename)
//            uri = Uri.fromFile(image)
            uri = FileProvider.getUriForFile(activity, "com.example.wallet.provider", image)
            fos = FileOutputStream(image)
        }
        fos?.use {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, uri)
                type = "image/*"
            }
            activity.startActivity(Intent.createChooser(intent, "FOTO"))
        }
    }
}