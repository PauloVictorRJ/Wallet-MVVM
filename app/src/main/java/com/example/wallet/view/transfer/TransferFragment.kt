package com.example.wallet.view.transfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wallet.R
import com.example.wallet.databinding.FragmentTransferBinding
import com.example.wallet.repositories.CardsRepository
import com.example.wallet.repositories.ContatoRepository
import com.example.wallet.repositories.TransactionsRepository
import com.example.wallet.viewmodel.HomeViewModel
import com.example.wallet.viewmodel.HomeViewModelFactory
import com.example.wallet.viewmodel.TransferViewModel
import com.example.wallet.viewmodel.TransferViewModelFactory


class TransferFragment : Fragment(R.layout.fragment_transfer) {
    private var _binding: FragmentTransferBinding? = null
    private val binding: FragmentTransferBinding get() = _binding!!

    private lateinit var viewModel: TransferViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTransferBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(
            this, TransferViewModelFactory(
                ContatoRepository()
            )
        ).get(
            TransferViewModel::class.java
        )
        viewModel.requestContatos()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var contatos_recycler = binding.contatosRecycler

        viewModel.liveListContato().observe(viewLifecycleOwner, Observer {
            contatos_recycler.adapter = TransferAdapter(it)
        })
        var back = binding.back
        back.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}