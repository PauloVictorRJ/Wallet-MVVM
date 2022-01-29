package com.example.wallet.repositories

import com.example.wallet.models.Contato
import com.example.wallet.models.ContatoJsonAdapter
import com.squareup.moshi.*
import org.json.JSONException
import org.json.JSONObject
import java.sql.Wrapper


class ContatoRepository {
    val contatosJson = """[
        {
            "name": "Paulo Victor",
            "image": "https://github.com/PauloVictorRJ.png",
            "type": "AMIGO"
        },
        {
            "name": "Denis Felippe",
            "image": "https://github.com/denisfelippe.png",
            "type": "PROFESSOR"
        },
        {
            "name": "Flávio Ferreira",
            "image": "https://github.com/flaviosfdev.png",
            "type": "AMIGO"
        },
        {
            "name": "Christiane Valeriano",
            "image": "https://github.com/Chrisvaleriano.png",
            "type": "AMIGA"
        },
        {
            "name": "Everton Antunes",
            "image": "https://github.com/itonAntunes.png",
            "type": "AMIGO"
        },
        {
            "name": "Eduardo Meireles",
            "image": "https://github.com/eduardomeireles87.png",
            "type": "AMIGO"
        },
        {
            "name": "Rafael Maneschy",
            "image": "https://github.com/rafamaneschy.png",
            "type": "AMIGO"
        },
        {
            "name": "Jonatas Araujo",
            "image": "https://github.com/jonatasaraujodh.png",
            "type": "PROFESSOR"
        }
    ]"""

    @OptIn(ExperimentalStdlibApi::class)
    fun getContatos(): MutableList<Contato> {
        val moshi = Moshi.Builder().build()
        val cardsJsonResponse: String = contatosJson
        val adapter = moshi.adapter<MutableList<Contato>>()
        val contatos: MutableList<Contato>? = adapter.fromJson(cardsJsonResponse)


        if (contatos != null) {
            return contatos
        } else
            return mutableListOf()
    }
}





