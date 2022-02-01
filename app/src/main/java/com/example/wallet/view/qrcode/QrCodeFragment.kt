package com.example.wallet.view.qrcode


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.wallet.R
import com.example.wallet.databinding.FragmentQrCodeBinding
import com.example.wallet.util.runOnUiThread


class QrCodeFragment : Fragment(R.layout.fragment_qr_code) {
    private var _binding: FragmentQrCodeBinding? = null
    private val binding: FragmentQrCodeBinding get() = _binding!!

    private lateinit var qr_code: CodeScanner
    private lateinit var codeScanner: CodeScanner

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQrCodeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scannerView: CodeScannerView = binding.scannerView
        val back = binding.back

        codeScanner = CodeScanner(view.context, scannerView)
        codeScanner.camera = CodeScanner.CAMERA_BACK // or CAMERA_FRONT or specific camera id
        codeScanner.formats = CodeScanner.ALL_FORMATS // list of type BarcodeFormat,
        // ex. listOf(BarcodeFormat.QR_CODE)
        codeScanner.autoFocusMode = AutoFocusMode.SAFE // or CONTINUOUS
        codeScanner.scanMode = ScanMode.SINGLE // or CONTINUOUS or PREVIEW
        codeScanner.isAutoFocusEnabled = true // Whether to enable auto focus or not
        codeScanner.isFlashEnabled = false // Whether to enable flash or not

        // Callbacks
        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                Toast.makeText(view.context, "Scan result: ${it.text}", Toast.LENGTH_LONG)
                    .show()
            }
        }
        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
            runOnUiThread {
                Toast.makeText(
                    view.context, "Camera initialization error: ${it.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }

        back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

//        val cameraCallback =
//            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//                if (it.resultCode == Activity.RESULT_OK) {
//                    startScanning()
//                }
//            }

//        val permission =
//            ContextCompat.checkSelfPermission(view.context, Manifest.permission.CAMERA)
//        if (permission == PackageManager.PERMISSION_GRANTED) {
//            val intent = Intent().apply {
//                action = MediaStore.ACTION_IMAGE_CAPTURE
//            }
//            cameraCallback.launch(intent)
//        }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}