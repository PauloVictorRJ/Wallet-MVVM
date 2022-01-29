package com.example.wallet.repositories

import com.example.wallet.models.Ofertas
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter

class OfertasRepository {
    val ofertasJson = """[
        {
            "image": "https://marcas-logos.net/wp-content/uploads/2020/03/WALMART-LOGO.jpg"
        },
        {
            "image": "https://logosmarcas.net/wp-content/uploads/2020/11/Carrefour-Logo-1966-1972.jpg"
        },
        {
            "image": "https://www.hippolysis.gr/wp-content/uploads/2014/12/grid-hp-logo-blue-535x300.jpg"
        },
        {
            "image": "https://logosmarcas.net/wp-content/uploads/2020/11/eBay-Logo-1999-2012.jpg"
        },
        {
            "image": "https://www.capef.com.br/site/wp-content/uploads/2020/07/logo-lojas-americanas.jpg"
        },
        {
            "image": "https://marcas-logos.net/wp-content/uploads/2020/01/Amazon-Logo-1.jpg"
        }
    ]"""

    @OptIn(ExperimentalStdlibApi::class)
    fun getOfertas(): MutableList<Ofertas> {
        val moshi = Moshi.Builder().build()
        val ofertasJsonResponse: String = ofertasJson
        val adapter = moshi.adapter<MutableList<Ofertas>>()
        val ofertas: MutableList<Ofertas>? = adapter.fromJson(ofertasJsonResponse)

        if (ofertas != null) {
            return ofertas
        } else
            return mutableListOf()
    }
}