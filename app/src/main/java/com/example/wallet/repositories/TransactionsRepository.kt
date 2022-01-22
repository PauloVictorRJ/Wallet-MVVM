package com.example.wallet.repositories

import com.example.wallet.models.Transaction


class TransactionsRepository {

        fun getTransactions0() : MutableList<Transaction>{
            return mutableListOf(
                Transaction("Hoje", null, null, null,0),
                Transaction("NetFlix", "Pagamento", "R$ 30", "https://cdn.cdnlogo.com/logos/n/82/netflix.png", 1),
                Transaction("Spotify", "Crédito", "R$ 20", "https://cdn.cdnlogo.com/logos/s/75/spotify.png", 1),
                Transaction("HBO Max", "Pagamento", "R$25", "https://hbomax-images.warnermediacdn.com/2020-05/square%20social%20logo%20400%20x%20400_0.png", 1),
                Transaction("Segunda, 5 de jan.", null, null, null,0),
                Transaction("Amazon Prime", "Crédito", "R$ 30", "https://otageek.com.br/wp-content/uploads/2021/11/Amazon-Prime-Video-Symbol.png", 1),
                Transaction("Disney+", "Crédito", "R$ 45", "https://cdn.cdnlogo.com/logos/d/31/disney.png", 1),
                Transaction("Deezer", "Crédito", "R$ 20", "https://cdn.cdnlogo.com/logos/d/6/deezer.png", 1),
                Transaction("Terça, 6 de jan.", null, null, null,0),
                Transaction("Apple", "Pagamento", "R$ 30", "https://www.apple.com/newsroom/images/tile-images/Apple-introduces-apple-tv-plus-03252019.jpg.landing-big_2x.jpg", 1),
                Transaction("Google", "Crédito", "R$ 40", "https://kedardesigns.com/wp-content/uploads/2015/09/Google-logo.jpg", 1),
                Transaction("Samsung Pay", "Pagamento", "R$ 10", "https://www.mastercard.com.br/content/dam/public/mastercardcom/lac/br/home/consumidores/solucoes-pagamento/carteiras-digitais/samsung-pay/samsung-pay-mastercard-1280x720.jpg", 1),
                Transaction("MercadoLivre", "Pagamento", "R$ 35", "https://s2.glbimg.com/Bu6upvmSg6SRv0za635uXphThKo=/620x430/e.glbimg.com/og/ed/f/original/2020/03/28/mercado-livre.jpg", 1),
                Transaction("Ebay", "Pagamento", "R$ 15", "https://ecommerce-platforms.com/wp-content/uploads/2014/08/ebay-189064_640-e1547217150438.png", 1),
                Transaction("Zé Delivery", "Crédito", "R$ 18", "https://emalta.com.br/wp-content/uploads/2016/08/ze-delivery-o-que-e.jpg", 1)
            )
        }

        fun getTransactions1() : MutableList<Transaction>{
            return mutableListOf(
                Transaction("Hoje", null, null, null,0),
                Transaction("Apple", "Pagamento", "R$ 30", "https://www.apple.com/newsroom/images/tile-images/Apple-introduces-apple-tv-plus-03252019.jpg.landing-big_2x.jpg", 1),
                Transaction("Google", "Crédito", "R$ 40", "https://kedardesigns.com/wp-content/uploads/2015/09/Google-logo.jpg", 1),
                Transaction("Samsung Pay", "Pagamento", "R$ 10", "https://www.mastercard.com.br/content/dam/public/mastercardcom/lac/br/home/consumidores/solucoes-pagamento/carteiras-digitais/samsung-pay/samsung-pay-mastercard-1280x720.jpg", 1),
                Transaction("MercadoLivre", "Pagamento", "R$ 35", "https://s2.glbimg.com/Bu6upvmSg6SRv0za635uXphThKo=/620x430/e.glbimg.com/og/ed/f/original/2020/03/28/mercado-livre.jpg", 1),
                Transaction("NetFlix", "Pagamento", "R$ 30", "https://cdn.cdnlogo.com/logos/n/82/netflix.png", 1),
                Transaction("Spotify", "Crédito", "R$ 20", "https://cdn.cdnlogo.com/logos/s/75/spotify.png", 1),
                Transaction("HBO Max", "Pagamento", "R$25", "https://hbomax-images.warnermediacdn.com/2020-05/square%20social%20logo%20400%20x%20400_0.png", 1),
                Transaction("Quarta, 11 de fev.", null, null, null,0),
                Transaction("Amazon Prime", "Crédito", "R$ 30", "https://otageek.com.br/wp-content/uploads/2021/11/Amazon-Prime-Video-Symbol.png", 1),
                Transaction("Disney+", "Crédito", "R$ 45", "https://cdn.cdnlogo.com/logos/d/31/disney.png", 1),
                Transaction("Deezer", "Crédito", "R$ 20", "https://cdn.cdnlogo.com/logos/d/6/deezer.png", 1),
                Transaction("Quinta, 12 de fev.", null, null, null,0),
                Transaction("Ebay", "Pagamento", "R$ 15", "https://ecommerce-platforms.com/wp-content/uploads/2014/08/ebay-189064_640-e1547217150438.png", 1),
                Transaction("Zé Delivery", "Crédito", "R$ 18", "https://emalta.com.br/wp-content/uploads/2016/08/ze-delivery-o-que-e.jpg", 1)
            )
        }

        fun getTransactions2() : MutableList<Transaction>{
            return mutableListOf(
                Transaction("Hoje", null, null, null,0),
                Transaction("Deezer", "Crédito", "R$ 20", "https://cdn.cdnlogo.com/logos/d/6/deezer.png", 1),
                Transaction("Sexta, 20 de mar.", null, null, null,0),
                Transaction("HBO Max", "Pagamento", "R$25", "https://hbomax-images.warnermediacdn.com/2020-05/square%20social%20logo%20400%20x%20400_0.png", 1),
                Transaction("Sábado, 21 de mar.", null, null, null,0),
                Transaction("Apple", "Pagamento", "R$ 30", "https://www.apple.com/newsroom/images/tile-images/Apple-introduces-apple-tv-plus-03252019.jpg.landing-big_2x.jpg", 1),
                Transaction("Google", "Crédito", "R$ 40", "https://kedardesigns.com/wp-content/uploads/2015/09/Google-logo.jpg", 1),
                Transaction("Samsung Pay", "Pagamento", "R$ 10", "https://www.mastercard.com.br/content/dam/public/mastercardcom/lac/br/home/consumidores/solucoes-pagamento/carteiras-digitais/samsung-pay/samsung-pay-mastercard-1280x720.jpg", 1),
                Transaction("MercadoLivre", "Pagamento", "R$ 35", "https://s2.glbimg.com/Bu6upvmSg6SRv0za635uXphThKo=/620x430/e.glbimg.com/og/ed/f/original/2020/03/28/mercado-livre.jpg", 1),
                Transaction("Ebay", "Pagamento", "R$ 15", "https://ecommerce-platforms.com/wp-content/uploads/2014/08/ebay-189064_640-e1547217150438.png", 1),
                Transaction("Zé Delivery", "Crédito", "R$ 18", "https://emalta.com.br/wp-content/uploads/2016/08/ze-delivery-o-que-e.jpg", 1)
            )
        }

        fun getTransactions3() : MutableList<Transaction>{
            return mutableListOf(
                Transaction("Hoje", null, null, null,0),
                Transaction("Apple", "Pagamento", "R$ 30", "https://www.apple.com/newsroom/images/tile-images/Apple-introduces-apple-tv-plus-03252019.jpg.landing-big_2x.jpg", 1),
                Transaction("Google", "Crédito", "R$ 40", "https://kedardesigns.com/wp-content/uploads/2015/09/Google-logo.jpg", 1),
                Transaction("Samsung Pay", "Pagamento", "R$ 10", "https://www.mastercard.com.br/content/dam/public/mastercardcom/lac/br/home/consumidores/solucoes-pagamento/carteiras-digitais/samsung-pay/samsung-pay-mastercard-1280x720.jpg", 1),
                Transaction("MercadoLivre", "Pagamento", "R$ 35", "https://s2.glbimg.com/Bu6upvmSg6SRv0za635uXphThKo=/620x430/e.glbimg.com/og/ed/f/original/2020/03/28/mercado-livre.jpg", 1),
                Transaction("NetFlix", "Pagamento", "R$ 30", "https://cdn.cdnlogo.com/logos/n/82/netflix.png", 1),
                Transaction("Spotify", "Crédito", "R$ 20", "https://cdn.cdnlogo.com/logos/s/75/spotify.png", 1),
                Transaction("HBO Max", "Pagamento", "R$25", "https://hbomax-images.warnermediacdn.com/2020-05/square%20social%20logo%20400%20x%20400_0.png", 1),
                Transaction("Domingo, 25 de abr.", null, null, null,0),
                Transaction("Deezer", "Crédito", "R$ 20", "https://cdn.cdnlogo.com/logos/d/6/deezer.png", 1),
                Transaction("Segunda, 26 de abr.", null, null, null,0),
                Transaction("Ebay", "Pagamento", "R$ 15", "https://ecommerce-platforms.com/wp-content/uploads/2014/08/ebay-189064_640-e1547217150438.png", 1),
                Transaction("Zé Delivery", "Crédito", "R$ 18", "https://emalta.com.br/wp-content/uploads/2016/08/ze-delivery-o-que-e.jpg", 1)
            )
        }

        fun getTransactions4() : MutableList<Transaction>{
            return mutableListOf(
                Transaction("Hoje", null, null, null,0),
                Transaction("NetFlix", "Pagamento", "R$ 30", "https://cdn.cdnlogo.com/logos/n/82/netflix.png", 1),
                Transaction("Terça, 17 de mai.", null, null, null,0),
                Transaction("Deezer", "Crédito", "R$ 20", "https://cdn.cdnlogo.com/logos/d/6/deezer.png", 1),
                Transaction("Quarta, 18 de mai.", null, null, null,0),
                Transaction("Apple", "Pagamento", "R$ 30", "https://www.apple.com/newsroom/images/tile-images/Apple-introduces-apple-tv-plus-03252019.jpg.landing-big_2x.jpg", 1)
            )
        }
}