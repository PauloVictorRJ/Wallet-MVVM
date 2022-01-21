package com.example.wallet.view.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.digitalhouse.dhwallet.util.decorator.HorizontalMarginItemDecoration
import com.example.wallet.R
import com.example.wallet.repositories.CardsRepository
import com.example.wallet.repositories.TransactionsRepository
import com.example.wallet.util.CustomPageTransformer
import com.example.wallet.viewmodel.HomeViewModel
import com.example.wallet.viewmodel.HomeViewModelFactory


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var viewModel: HomeViewModel
    private val transactionAdapter = HomeRvTransactionsAdapater()
    private lateinit var cardsAdapter: HomeCardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            HomeViewModelFactory(TransactionsRepository(), CardsRepository())
        ).get(
            HomeViewModel::class.java
        )

        viewModel.requestTransactions()
        viewModel.requestCards()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager2: ViewPager2 = view.findViewById(R.id.list_card)
        cardsAdapter = HomeCardAdapter(this)
        viewPager2.adapter = cardsAdapter

        viewPager2.setPageTransformer(CustomPageTransformer(view.context))
        viewPager2.offscreenPageLimit = 1

        viewPager2.addItemDecoration(
            HorizontalMarginItemDecoration(
                view.context,
                R.dimen.viewpager_current_item_horizontal_margin
            )
        )

        viewModel.liveListCards.observe(viewLifecycleOwner, Observer {
            cardsAdapter.setListCards(it)
        })

        val rvHomeTransacoes: RecyclerView = view.findViewById(R.id.rv_home_transacoes)
        rvHomeTransacoes.adapter = transactionAdapter

        viewModel.liveListTransactions.observe(viewLifecycleOwner, Observer {
            transactionAdapter.setListaTransaction(it)
        })
    }
}
