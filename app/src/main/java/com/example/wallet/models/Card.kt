package com.example.wallet.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import androidx.annotation.DrawableRes


@Parcelize
data class Card(
val limite: String,
@DrawableRes val bandeira: Int,
val numero: String,
val nome: String,
val validade: String,
@DrawableRes val background: Int
): Parcelable

