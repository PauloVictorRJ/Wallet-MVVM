package com.example.wallet.view.transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.wallet.R
import com.example.wallet.databinding.FragmentHomeBinding
import com.example.wallet.databinding.FragmentTransactionsBinding
import com.example.wallet.view.cardinfo.CardInfoFragmentArgs


class TransactionsFragment : Fragment(R.layout.fragment_transactions) {
    private var _binding: FragmentTransactionsBinding? = null
    private val binding: FragmentTransactionsBinding get() = _binding!!

    private val safeArgsRx by navArgs<TransactionsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTransactionsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var transaction_recycler = binding.transactionRecycler
        var actualTransacion = (safeArgsRx.txTransactions).toList()
        transaction_recycler.adapter = TransactionsAdapter(actualTransacion)

        var btn_transferir = binding.btnTransferir
        btn_transferir.setOnClickListener{
            findNavController().navigate(TransactionsFragmentDirections.actionTransactionsFragmentToTransferFragment())
        }
    }
}