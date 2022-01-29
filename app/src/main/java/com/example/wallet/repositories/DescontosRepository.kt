package com.example.wallet.repositories

import com.example.wallet.models.Descontos
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter

class DescontosRepository {
    val descontosJson = """[
        {
            "image": "https://i.pinimg.com/originals/84/57/e0/8457e05abadaa5aff79568db5e3fefba.jpg"
        },
        {
            "image": "https://marcas-logos.net/wp-content/uploads/2020/11/Logo-AOC.jpg"
        },
        {
            "image": "https://logosmarcas.net/wp-content/uploads/2020/11/Logitech-Logo-1997-2012.jpg"
        },
        {
            "image": "https://logodownload.org/wp-content/uploads/2016/10/jbl-logo-9.png"
        },
        {
            "image": "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Lg_logo_II_c%C3%B3pia.jpg/1200px-Lg_logo_II_c%C3%B3pia.jpg"
        },
        {
            "image": "https://logodownload.org/wp-content/uploads/2014/10/motorola-logo-2.jpg"
        }
    ]"""

    @OptIn(ExperimentalStdlibApi::class)
    fun getDescontos(): MutableList<Descontos> {
        val moshi = Moshi.Builder().build()
        val descontosJsonResponse: String = descontosJson
        val adapter = moshi.adapter<MutableList<Descontos>>()
        val descontos: MutableList<Descontos>? = adapter.fromJson(descontosJsonResponse)

        if (descontos != null) {
            return descontos
        } else
            return mutableListOf()
    }
}
