package com.example.wallet.view.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.R
import com.example.wallet.repositories.TransactionsRepository
import com.example.wallet.viewmodel.HomeViewModel
import com.example.wallet.viewmodel.HomeViewModelFactory


class Home : Fragment(R.layout.fragment_home) {
    private lateinit var viewModel: HomeViewModel
    private val transactionAdapter = HomeTransactionAdapter.HomeRvTransactionsAdapater()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, HomeViewModelFactory(TransactionsRepository())).get(
            HomeViewModel::class.java
        )
        viewModel.request()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.liveList.observe(viewLifecycleOwner, Observer {
            transactionAdapter.setListaTransaction(it)

        })

        val rvHomeTransacoes: RecyclerView = view.findViewById(R.id.rv_home_transacoes)
        rvHomeTransacoes.adapter = transactionAdapter
    }

    override fun onResume() {
        super.onResume()
        viewModel.request()
    }
}



