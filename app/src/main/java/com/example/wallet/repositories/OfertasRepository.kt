package com.example.wallet.repositories

import com.example.wallet.models.Ofertas

class OfertasRepository {
    fun getOfertas() : MutableList<Ofertas>{
        return mutableListOf(
            Ofertas("https://marcas-logos.net/wp-content/uploads/2020/03/WALMART-LOGO.jpg"),
            Ofertas("https://logosmarcas.net/wp-content/uploads/2020/11/Carrefour-Logo-1966-1972.jpg"),
            Ofertas("https://www.hippolysis.gr/wp-content/uploads/2014/12/grid-hp-logo-blue-535x300.jpg"),
            Ofertas("https://logosmarcas.net/wp-content/uploads/2020/11/eBay-Logo-1999-2012.jpg"),
            Ofertas("https://www.capef.com.br/site/wp-content/uploads/2020/07/logo-lojas-americanas.jpg"),
            Ofertas("https://marcas-logos.net/wp-content/uploads/2020/01/Amazon-Logo-1.jpg"),
        )
    }
}