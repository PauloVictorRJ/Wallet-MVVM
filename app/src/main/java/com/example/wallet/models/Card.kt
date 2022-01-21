package com.example.wallet.models

import androidx.annotation.DrawableRes


data class Card(
val limite: String,
val bandeira: Int,
val numero: String,
val nome: String,
val validade: String,
@DrawableRes val background: Int
)

