package com.example.wallet.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class Contato(
    @Json(name = "image") val contactImage: String,
    @Json(name = "name") val contactName: String,
    @Json(name = "type") val contactType: ContactType
)

enum class ContactType(val description: String) {
    IRMA("Irmã"),
    IRMAO("Irmão"),
    ESPOSA("Esposa"),
    AMIGA("Amiga"),
    AMIGO("Amigo"),
    MAE("Mãe"),
    PROFESSOR("Professor")
}
