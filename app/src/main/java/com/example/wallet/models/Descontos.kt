package com.example.wallet.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Descontos(
    @Json(name = "image") val descontosImage: String
)
