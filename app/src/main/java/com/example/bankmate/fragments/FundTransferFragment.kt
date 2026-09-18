package com.example.bankmate.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bankmate.R
import com.example.bankmate.TransactionActivity
import com.example.bankmate.databinding.FragmentFundTransferBinding
import com.example.bankmate.model.AccountRepository

class FundTransferFragment : Fragment() {

    private var _binding: FragmentFundTransferBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFundTransferBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConfirmTransfer.setOnClickListener {
            if (validateInputs()) {
                performTransfer()
            }
        }
    }

    private fun validateInputs(): Boolean {
        var isValid = true

        val beneficiaryName = binding.etBeneficiaryName.text?.toString()?.trim().orEmpty()
        val accountNumber = binding.etAccountNumber.text?.toString()?.trim().orEmpty()
        val amountText = binding.etAmount.text?.toString()?.trim().orEmpty()

        if (beneficiaryName.isEmpty()) {
            binding.tilBeneficiaryName.error = getString(R.string.error_beneficiary_empty)
            isValid = false
        } else {
            binding.tilBeneficiaryName.error = null
        }

        if (accountNumber.isEmpty()) {
            binding.tilAccountNumber.error = getString(R.string.error_account_empty)
            isValid = false
        } else {
            binding.tilAccountNumber.error = null
        }

        val amount = amountText.toDoubleOrNull()
        when {
            amountText.isEmpty() || amount == null -> {
                binding.tilAmount.error = getString(R.string.error_amount_invalid)
                isValid = false
            }
            amount <= 0.0 -> {
                binding.tilAmount.error = getString(R.string.error_amount_zero)
                isValid = false
            }
            !AccountRepository.hasSufficientBalance(amount) -> {
                binding.tilAmount.error = getString(R.string.error_insufficient_balance)
                isValid = false
            }
            else -> {
                binding.tilAmount.error = null
            }
        }

        if (binding.rgTransferMode.checkedRadioButtonId == -1) {
            Toast.makeText(
                requireContext(),
                getString(R.string.error_mode_not_selected),
                Toast.LENGTH_SHORT
            ).show()
            isValid = false
        }

        return isValid
    }

    private fun performTransfer() {
        val beneficiaryName = binding.etBeneficiaryName.text.toString().trim()
        val accountNumber = binding.etAccountNumber.text.toString().trim()
        val amount = binding.etAmount.text.toString().trim().toDouble()

        val transferMode = when (binding.rgTransferMode.checkedRadioButtonId) {
            R.id.rbImps -> "IMPS"
            R.id.rbNeft -> "NEFT"
            R.id.rbUpi -> "UPI"
            else -> "IMPS"
        }

        val intent = Intent(requireContext(), TransactionActivity::class.java).apply {
            putExtra(TransactionActivity.EXTRA_BENEFICIARY_NAME, beneficiaryName)
            putExtra(TransactionActivity.EXTRA_ACCOUNT_NUMBER, accountNumber)
            putExtra(TransactionActivity.EXTRA_AMOUNT, amount)
            putExtra(TransactionActivity.EXTRA_TRANSFER_MODE, transferMode)
        }
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = FundTransferFragment()
    }
}