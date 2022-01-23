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
import com.example.wallet.repositories.CardsRepository
import com.example.wallet.repositories.DescontosRepository
import com.example.wallet.repositories.OfertasRepository
import com.example.wallet.repositories.TransactionsRepository
import com.example.wallet.util.CustomPageTransformer
import com.example.wallet.viewmodel.MainViewModel
import com.example.wallet.viewmodel.MainViewModelFactory


class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    private val transactionAdapter = HomeRvTransactionsAdapater()
    private lateinit var cardsAdapter: HomeCardAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        cardsAdapter = HomeCardAdapter(this, action = {
            findNavController().navigate(R.id.action_home_to_cardInfoFragment)
        })

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(TransactionsRepository(), CardsRepository(),
                DescontosRepository(), OfertasRepository())
        ).get(
            MainViewModel::class.java
        )

        viewModel.requestTransactions()
        viewModel.requestCards()

        return binding.root
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvHomeTransacoes = binding.rvHomeTransacoes
        rvHomeTransacoes.adapter = transactionAdapter

        val viewPager2 = binding.listCard
        viewPager2.adapter = cardsAdapter

        viewModel.liveListCards.observe(viewLifecycleOwner, Observer {
            cardsAdapter.setListCards(it)
        })

        viewModel.liveListTransactions.observe(viewLifecycleOwner, Observer {
            transactionAdapter.setListaTransaction(it)
        })

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}