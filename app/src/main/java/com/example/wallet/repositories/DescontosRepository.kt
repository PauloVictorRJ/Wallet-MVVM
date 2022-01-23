package com.example.wallet.repositories

import com.example.wallet.models.Descontos

class DescontosRepository {
    fun getDescontos(): MutableList<Descontos> {
        return mutableListOf(
            Descontos("https://i.pinimg.com/originals/84/57/e0/8457e05abadaa5aff79568db5e3fefba.jpg"),
            Descontos("https://marcas-logos.net/wp-content/uploads/2020/11/Logo-AOC.jpg"),
            Descontos("https://logosmarcas.net/wp-content/uploads/2020/11/Logitech-Logo-1997-2012.jpg"),
            Descontos("https://logodownload.org/wp-content/uploads/2016/10/jbl-logo-9.png"),
            Descontos("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Lg_logo_II_c%C3%B3pia.jpg/1200px-Lg_logo_II_c%C3%B3pia.jpg"),
            Descontos("https://logodownload.org/wp-content/uploads/2014/10/motorola-logo-2.jpg")
        )
    }
}