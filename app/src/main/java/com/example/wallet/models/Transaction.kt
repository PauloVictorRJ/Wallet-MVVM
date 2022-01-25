package com.example.wallet.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Transaction(
    val title: String,
    val subtitle: String?,
    val value: String?,
    val image: String?,
    val viewType: Int
) : Parcelable