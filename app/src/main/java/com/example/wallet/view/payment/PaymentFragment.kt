package com.example.wallet.view.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wallet.R
import com.example.wallet.databinding.FragmentPagamentoBinding
import com.example.wallet.repositories.ConcessionairesRepository
import com.example.wallet.viewmodel.ConcessionairesFactory
import com.example.wallet.viewmodel.ConcessionairesViewModel


class PaymentFragment : Fragment(R.layout.fragment_pagamento) {
    private var _binding: FragmentPagamentoBinding? = null
    private val binding: FragmentPagamentoBinding get() = _binding!!

    private lateinit var viewModel: ConcessionairesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPagamentoBinding.inflate(inflater, container, false)

        var rv_mais_usados = binding.rvMaisUsados

        viewModel = ViewModelProvider(
            this, ConcessionairesFactory(
                ConcessionairesRepository()
            )
        ).get(
            ConcessionairesViewModel::class.java
        )

        viewModel.requestConcessionaires()

        viewModel.liveListConcessionaires().observe(viewLifecycleOwner, Observer {
            rv_mais_usados.adapter = PaymentAdapter(it)
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var back = binding.back

        back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
