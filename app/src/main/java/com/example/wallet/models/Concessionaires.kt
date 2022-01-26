package com.example.wallet.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
class Concessionaires(
    val name: String,
    val address:String,
    @DrawableRes val image: Int,
) : Parcelable
