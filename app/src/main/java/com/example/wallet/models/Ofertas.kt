package com.example.wallet.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ofertas(
    @Json(name = "image") val ofertasImage: String
)
