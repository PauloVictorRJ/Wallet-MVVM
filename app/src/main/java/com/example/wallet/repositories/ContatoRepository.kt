package com.example.wallet.repositories

import com.example.wallet.models.ContactType
import com.example.wallet.models.Contato


class ContatoRepository {
    fun getContatos(): MutableList<Contato> {
        return mutableListOf(
            Contato(
                image = "https://github.com/PauloVictorRJ.png",
                name = "Paulo Victor",
                type = ContactType.AMIGO
            ),
            Contato(
                image = "https://github.com/denisfelippe.png",
                name = "Denis Felippe",
                type = ContactType.PROFESSOR
            ),
            Contato(
                image = "https://github.com/flaviosfdev.png",
                name = "Flávio Ferreira",
                type = ContactType.AMIGO
            ),
            Contato(
                image = "https://github.com/Chrisvaleriano.png",
                name = "Christiane Valeriano",
                type = ContactType.AMIGA
            ),
            Contato(
                image = "https://github.com/itonAntunes.png",
                name = "Everton Antunes",
                type = ContactType.AMIGO
            ),
            Contato(
                image = "https://github.com/eduardomeireles87.png",
                name = "Eduardo Meireles",
                type = ContactType.AMIGO
            ),
            Contato(
                image = "https://github.com/rafamaneschy.png",
                name = "Rafael Maneschy",
                type = ContactType.AMIGO
            ),
            Contato(
                image = "https://github.com/jonatasaraujodh.png",
                name = "Jonatas Araujo",
                type = ContactType.PROFESSOR
            )
        )
    }
}