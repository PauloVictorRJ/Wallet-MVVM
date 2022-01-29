package com.example.wallet.view.transfer

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wallet.R
import com.example.wallet.databinding.FragmentTransferBinding
import com.example.wallet.repositories.ContatoRepository
import com.example.wallet.viewmodel.TransferViewModel
import com.example.wallet.viewmodel.TransferViewModelFactory


class TransferFragment : Fragment(R.layout.fragment_transfer) {
    private var _binding: FragmentTransferBinding? = null
    private val binding: FragmentTransferBinding get() = _binding!!

    private lateinit var viewModel: TransferViewModel

    private val permissionsResultCallback = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            Toast.makeText(requireContext(), "Permitido", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Não permitido", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTransferBinding.inflate(inflater, container, false)

        var contatos_recycler = binding.contatosRecycler

        viewModel = ViewModelProvider(
            this, TransferViewModelFactory(
                ContatoRepository()
            )
        ).get(
            TransferViewModel::class.java
        )
        viewModel.requestContatos()

        viewModel.liveListContato().observe(viewLifecycleOwner, Observer {
            contatos_recycler.adapter = TransferAdapter(it)
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btn_print_and_share = binding.btnPrintAndShare

        var back = binding.back
        back.setOnClickListener {
            findNavController().popBackStack()
        }

        btn_print_and_share.setOnClickListener {
//            viewModel.vmPrintScreen(view, requireActivity())
            val permission =
                ContextCompat.checkSelfPermission(it.context, Manifest.permission.CAMERA)
            if (permission != PackageManager.PERMISSION_GRANTED) {
                permissionsResultCallback.launch(Manifest.permission.CAMERA)
            } else {
                Toast.makeText(requireContext(), "Já está permitido!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
