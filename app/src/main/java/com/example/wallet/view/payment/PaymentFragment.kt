package com.example.wallet.view.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wallet.R
import com.example.wallet.databinding.FragmentCardInfoBinding
import com.example.wallet.databinding.FragmentPagamentoBinding


class PaymentFragment : Fragment(R.layout.fragment_pagamento) {
    private var _binding: FragmentPagamentoBinding? = null
    private val binding: FragmentPagamentoBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPagamentoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var back = binding.back
    }
}
