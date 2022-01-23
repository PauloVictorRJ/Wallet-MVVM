package com.example.wallet.view.cardinfo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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


class CardInfoFragment() : Fragment(R.layout.fragment_card_info) {
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
                TransactionsRepository(),
                CardsRepository(),
                DescontosRepository(),
                OfertasRepository()
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
        var card_info_fundo = binding.cardInfoFundo
        var card_info_limite = binding.cardInfoLimite
        var card_info_bandeira = binding.cardInfoBandeira
        var card_info_numero_final = binding.cardInfoNumeroFinal
        var card_info_nome = binding.cardInfoNome
        var card_info_validade = binding.cardInfoValidade

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

        viewModel.liveListCardInfo.observe(viewLifecycleOwner, Observer {
            card_info_limite.text = it.limite
            card_info_numero_final.text = it.numero
            card_info_nome.text = it.nome
            card_info_validade.text = it.validade
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
