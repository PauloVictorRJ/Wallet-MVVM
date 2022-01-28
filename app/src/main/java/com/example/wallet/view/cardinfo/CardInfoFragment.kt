package com.example.wallet.view.cardinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.wallet.R
import com.example.wallet.databinding.FragmentCardInfoBinding
import com.example.wallet.repositories.*
import com.example.wallet.view.home.HomeFragmentDirections
import com.example.wallet.viewmodel.CardInfoViewModel
import com.example.wallet.viewmodel.CardInfoViewModelFactory
import com.example.wallet.viewmodel.HomeViewModel
import com.example.wallet.viewmodel.HomeViewModelFactory


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

        _binding = FragmentCardInfoBinding.inflate(inflater, container, false)

        var rxCard = safeArgsRx.txCard

        val rvOfertas = binding.cardInfoRvOfertas
        val rvDescontos = binding.cardInfoRvDescontos

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

        viewModel = ViewModelProvider(
            this, CardInfoViewModelFactory(
                DescontosRepository(), OfertasRepository()
            )
        ).get(
            CardInfoViewModel::class.java
        )

        viewModel.requestDescontos()
        viewModel.requestOfertas()

        viewModel.liveListOfertas().observe(viewLifecycleOwner, Observer {
            ofertasAdapter.setListOfertas(it)
        })

        viewModel.liveListDescontos().observe(viewLifecycleOwner, Observer {
            descontosAdapter.setListDescontos(it)
        })

        rvOfertas.adapter = ofertasAdapter
        rvDescontos.adapter = descontosAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var rxTransaction = safeArgsRx.txTransactions

        var btn_transfer = binding.btnTransfer
        var btn_transactions = binding.btnTransactions
        var btn_payment = binding.btnPayment
        var back = binding.back

        btn_transfer.setOnClickListener {
            findNavController().navigate(
                CardInfoFragmentDirections.actionCardInfoFragmentToTransferFragment()
            )
        }

        btn_transactions.setOnClickListener {
            findNavController().navigate(
                CardInfoFragmentDirections.actionCardInfoFragmentToTransactionsFragment(
                    rxTransaction
                )
            )
        }

        btn_payment.setOnClickListener {
            findNavController().navigate(CardInfoFragmentDirections.actionCardInfoFragmentToPaymentFragment())
        }

        back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
