package com.example.wallet.view.home

import android.os.Bundle
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

        val rvHomeTransacoes = binding.rvHomeTransacoes
        val viewPager2 = binding.listCard

        var viewPager2Changed = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewModel.selectedCard(position)
            }
        }

        viewPager2.setPageTransformer(CustomPageTransformer(viewPager2.context))
        viewPager2.offscreenPageLimit = 1
        viewPager2.addItemDecoration(
            HorizontalMarginItemDecoration(
                viewPager2.context, R.dimen.viewpager_current_item_horizontal_margin
            )
        )

        viewPager2.registerOnPageChangeCallback(viewPager2Changed)

        viewModel = ViewModelProvider(
            this, HomeViewModelFactory(
                TransactionsRepository(), CardsRepository(),
            )
        ).get(
            HomeViewModel::class.java
        )

        viewModel.requestTransactions()
        viewModel.requestCards()

        viewModel.liveListCards().observe(viewLifecycleOwner, Observer {
            cardsAdapter.setListCards(it)
        })

        viewModel.liveListTransactions().observe(viewLifecycleOwner, Observer {
            homeTransactionAdapter.setListaTransaction(it)
        })

        cardsAdapter = HomeCardAdapter(this, action = {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeToCardInfoFragment(
                    cardsAdapter.cartaoAtual, viewModel.returnSelectedTransaction().toTypedArray()
                )
            )
        })

        viewPager2.adapter = cardsAdapter
        rvHomeTransacoes.adapter = homeTransactionAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn_send_to_transactions = binding.btnSendToTransactions
        val btn_back = binding.btnBack

        btn_send_to_transactions.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToTransactionsFragment(
                    viewModel.returnSelectedTransaction().toTypedArray()
                )
            )
        }

        btn_back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}