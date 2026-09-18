package com.example.bankmate.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankmate.adapter.TransactionAdapter
import com.example.bankmate.databinding.FragmentTransactionHistoryBinding
import com.example.bankmate.model.Transaction

/**
 * Displays a static, sample list of past transactions
 * using a RecyclerView, for academic demonstration purposes.
 */
class TransactionHistoryFragment : Fragment() {

    private var _binding: FragmentTransactionHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransactionHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTransactionHistory.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTransactionHistory.adapter = TransactionAdapter(sampleTransactions())
    }

    private fun sampleTransactions(): List<Transaction> = listOf(
        Transaction("Rahul", "XXXX1234", 2000.0, "UPI"),
        Transaction("Amit", "XXXX5678", 5000.0, "NEFT"),
        Transaction("Priya Menon", "XXXX9012", 1200.0, "IMPS"),
        Transaction("Sana Traders", "XXXX3456", 8500.0, "NEFT"),
        Transaction("Karthik R", "XXXX7890", 750.0, "UPI")
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = TransactionHistoryFragment()
    }
}
