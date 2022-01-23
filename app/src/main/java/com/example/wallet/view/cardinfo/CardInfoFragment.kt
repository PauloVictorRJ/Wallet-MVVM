package com.example.wallet.view.cardinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.wallet.R
import com.example.wallet.databinding.FragmentCardInfoBinding
import com.example.wallet.repositories.CardsRepository
import com.example.wallet.repositories.DescontosRepository
import com.example.wallet.repositories.OfertasRepository
import com.example.wallet.repositories.TransactionsRepository
import com.example.wallet.viewmodel.MainViewModel
import com.example.wallet.viewmodel.MainViewModelFactory


class CardInfoFragment : Fragment(R.layout.fragment_card_info) {
    private var _binding: FragmentCardInfoBinding? = null
    private val binding: FragmentCardInfoBinding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    private var descontosAdapter = CardInfoDescontosAdapter()
    private var ofertasAdapter = CardInfoOfertasAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardInfoBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(
                TransactionsRepository(), CardsRepository(),
                DescontosRepository(), OfertasRepository()
            )
        ).get(
            MainViewModel::class.java
        )

        viewModel.requestDescontos()
        viewModel.requestOfertas()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvOfertas = binding.cardInfoRvOfertas
        rvOfertas.adapter = ofertasAdapter

        viewModel.liveListOfertas.observe(viewLifecycleOwner, Observer {
            ofertasAdapter.setListOfertas(it)
        })

        val rvDescontos = binding.cardInfoRvDescontos
        rvDescontos.adapter = descontosAdapter

        viewModel.liveListDescontos.observe(viewLifecycleOwner, Observer {
            descontosAdapter.setListDescontos(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
