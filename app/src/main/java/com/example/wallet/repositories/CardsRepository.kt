package com.example.wallet.repositories

import com.example.wallet.R
import com.example.wallet.models.Card


class CardsRepository {
    fun getCards(): MutableList<Card> {
        return mutableListOf(
            Card("R$ 100,00", R.drawable.ic_mastercard, "1234", "Paulo Victor", "03/28", R.drawable.background_card_gray),
            Card("R$ 200,00", R.drawable.ic_visa, "5678", "José Victor", "04/28", R.drawable.background_card_blue),
            Card("R$ 300,00", R.drawable.ic_mastercard, "9101", "Denis Victor", "05/28", R.drawable.background_card_green),
            Card("R$ 400,00", R.drawable.ic_visa, "1213", "Luis Victor", "06/28",R.drawable.background_card_red),
            Card("R$ 500,00", R.drawable.ic_mastercard, "1415", "João Victor", "07/28", R.drawable.background_card_lime)
        )
    }
}