package com.example.bankmate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankmate.R
import com.example.bankmate.databinding.ItemTransactionBinding
import com.example.bankmate.model.Transaction
import java.util.Locale

/**
 * RecyclerView adapter that displays a static list of
 * sample Transaction objects for the Transaction History screen.
 */
class TransactionAdapter(
    private val transactions: List<Transaction>
) : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    inner class TransactionViewHolder(val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemTransactionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]
        with(holder.binding) {
            tvItemMode.text = "${transaction.transferMode} Transfer"
            tvItemBeneficiary.text = transaction.beneficiaryName
            tvItemAmount.text = String.format(Locale.getDefault(), "₹%,.0f", transaction.amount)
            tvItemStatus.text = transaction.status

            val iconRes = when (transaction.transferMode) {
                "UPI" -> R.drawable.ic_upi
                "NEFT" -> R.drawable.ic_neft
                "IMPS" -> R.drawable.ic_imps
                else -> R.drawable.ic_fund_transfer
            }
            ivModeIcon.setImageResource(iconRes)
        }
    }

    override fun getItemCount(): Int = transactions.size
}
