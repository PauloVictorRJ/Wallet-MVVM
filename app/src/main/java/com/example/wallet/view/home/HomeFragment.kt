package com.example.wallet.view.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.digitalhouse.dhwallet.util.decorator.HorizontalMarginItemDecoration
import com.example.wallet.R
import com.example.wallet.databinding.FragmentHomeBinding
import com.example.wallet.models.Transaction
import com.example.wallet.repositories.*
import com.example.wallet.util.CustomPageTransformer
import com.example.wallet.viewmodel.HomeViewModel
import com.example.wallet.viewmodel.HomeViewModelFactory


class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private lateinit var viewModel: HomeViewModel

    private val homeTransactionAdapter = HomeRvTransactionsAdapater()
    private lateinit var cardsAdapter: HomeCardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(
            this, HomeViewModelFactory(
                TransactionsRepository(), CardsRepository(),
            )
        ).get(
            HomeViewModel::class.java
        )

        viewModel.requestTransactions()
        viewModel.requestCards()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager2 = binding.listCard
        val rvHomeTransacoes = binding.rvHomeTransacoes

        val btn_send_to_transactions = binding.btnSendToTransactions

        viewModel.liveListTransactions().observe(viewLifecycleOwner, Observer {
            homeTransactionAdapter.setListaTransaction(it)
        })

        rvHomeTransacoes.adapter = homeTransactionAdapter

        viewPager2.setPageTransformer(CustomPageTransformer(view.context))
        viewPager2.offscreenPageLimit = 1
        viewPager2.addItemDecoration(
            HorizontalMarginItemDecoration(
                view.context, R.dimen.viewpager_current_item_horizontal_margin
            )
        )

        var viewPager2Changed = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewModel.selectedCard(position)
            }
        }

        viewPager2.registerOnPageChangeCallback(viewPager2Changed)

        cardsAdapter = HomeCardAdapter(this, action = {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeToCardInfoFragment(
                    cardsAdapter.cartaoAtual, viewModel.returnSelectedTransaction().toTypedArray()
                )
            )
        })

        viewPager2.adapter = cardsAdapter
        viewModel.liveListCards().observe(viewLifecycleOwner, Observer {
            cardsAdapter.setListCards(it)
        })

        btn_send_to_transactions.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToTransactionsFragment(
                    viewModel.returnSelectedTransaction().toTypedArray()
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}