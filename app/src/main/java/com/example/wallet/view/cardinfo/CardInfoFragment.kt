package com.example.wallet.view.cardinfo

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.wallet.R
import com.example.wallet.databinding.FragmentCardInfoBinding
import com.example.wallet.repositories.*
import com.example.wallet.viewmodel.CardInfoViewModel
import com.example.wallet.viewmodel.CardInfoViewModelFactory


class CardInfoFragment() : Fragment(R.layout.fragment_card_info) {
    private var _binding: FragmentCardInfoBinding? = null
    private val binding: FragmentCardInfoBinding get() = _binding!!

    private val safeArgsRx by navArgs<CardInfoFragmentArgs>()

    private lateinit var viewModel: CardInfoViewModel

    private var descontosAdapter = CardInfoDescontosAdapter()
    private var ofertasAdapter = CardInfoOfertasAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rxCard = safeArgsRx.txCard

        _binding = FragmentCardInfoBinding.inflate(inflater, container, false)

        var card_info_fundo = binding.cardInfoFundo
        card_info_fundo.setBackgroundResource(rxCard.background)

        var card_info_limite = binding.cardInfoLimite
        card_info_limite.text = rxCard.limite

        var card_info_bandeira = binding.cardInfoBandeira
        card_info_bandeira.setImageResource(rxCard.bandeira)

        var card_info_numero_final = binding.cardInfoNumeroFinal
        card_info_numero_final.text = rxCard.numero

        var card_info_nome = binding.cardInfoNome
        card_info_nome.text = rxCard.nome

        var card_info_validade = binding.cardInfoValidade
        card_info_validade.text = rxCard.validade

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel = ViewModelProvider(
            this, CardInfoViewModelFactory(
                DescontosRepository(), OfertasRepository()
            )
        ).get(
            CardInfoViewModel::class.java
        )

        viewModel.requestDescontos()
        viewModel.requestOfertas()

        val rvOfertas = binding.cardInfoRvOfertas
        rvOfertas.adapter = ofertasAdapter

        viewModel.liveListOfertas().observe(viewLifecycleOwner, Observer {
            ofertasAdapter.setListOfertas(it)
        })

        val rvDescontos = binding.cardInfoRvDescontos
        rvDescontos.adapter = descontosAdapter

        viewModel.liveListDescontos().observe(viewLifecycleOwner, Observer {
            descontosAdapter.setListDescontos(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
