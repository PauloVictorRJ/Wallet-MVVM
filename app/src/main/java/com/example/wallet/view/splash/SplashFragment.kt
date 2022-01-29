package com.example.wallet.view.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wallet.R
import com.example.wallet.databinding.SplashFragmentBinding


class SplashFragment : Fragment(R.layout.splash_fragment) {

    private var _binding: SplashFragmentBinding? = null
    private val binding: SplashFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = SplashFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btn_start = binding.start
        btn_start.setOnClickListener {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
