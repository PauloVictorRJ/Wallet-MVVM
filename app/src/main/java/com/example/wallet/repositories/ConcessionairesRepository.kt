package com.example.wallet.repositories

import com.example.wallet.R
import com.example.wallet.models.Concessionaires


class ConcessionairesRepository {
    fun getConcessionaires(): MutableList<Concessionaires> {
        return mutableListOf(
            Concessionaires("Cedae", "R. José Bonifácio, 528",R.drawable.empresa_cedae),
            Concessionaires("Claro","R. Hermengarda, 60", R.drawable.empresa_claro),
            Concessionaires("Light","R. Maxwell, 56", R.drawable.empresa_light),
            Concessionaires("Naturgy","Rua Conde de Bonfim, 645 ", R.drawable.empresa_naturgy),
            Concessionaires("Nextel","Estr. do Portela, 222", R.drawable.empresa_nextel),
            Concessionaires("Oi","R. Intendente Cunha Menezes, 191", R.drawable.empresa_oi),
            Concessionaires("Tim","Av. Pastor Martin Luther King Júnior, 126", R.drawable.empresa_tim),
            Concessionaires("Vivo","Avenida Dom Helder Câmara, 5474", R.drawable.empresa_vivo)
        )
    }
}