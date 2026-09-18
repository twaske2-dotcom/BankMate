package com.example.bankmate.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bankmate.databinding.FragmentAccountDetailsBinding
import com.example.bankmate.model.AccountRepository
import java.util.Locale

class AccountDetailsFragment : Fragment() {

    private var _binding: FragmentAccountDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvAvailableBalance.text =
            String.format(Locale.getDefault(), "₹%,.2f", AccountRepository.balance)
    }

    override fun onResume() {
        super.onResume()
        binding.tvAvailableBalance.text =
            String.format(Locale.getDefault(), "₹%,.2f", AccountRepository.balance)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = AccountDetailsFragment()
    }
}