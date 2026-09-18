package com.example.bankmate

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bankmate.databinding.ActivityMainBinding
import com.example.bankmate.fragments.AccountDetailsFragment
import com.example.bankmate.fragments.FundTransferFragment
import com.example.bankmate.fragments.TransactionHistoryFragment
import com.example.bankmate.model.AccountRepository
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val TAG = "BankMate"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDashboard()
        setupServiceCards()

        if (savedInstanceState == null) {
            loadFragment(AccountDetailsFragment.newInstance())
        }
    }

    private fun setupDashboard() {
        val customerName = getString(R.string.customer_name_sample)
        val firstName = customerName.split(" ").firstOrNull() ?: customerName
        binding.tvGreeting.text = getString(R.string.greeting_morning) + ", $firstName \uD83D\uDC4B"
        refreshBalance()
    }

    private fun refreshBalance() {
        binding.tvBalance.text = String.format(Locale.getDefault(), "₹%,.2f", AccountRepository.balance)
    }

    private fun setupServiceCards() {
        binding.cardAccountDetails.setOnClickListener {
            loadFragment(AccountDetailsFragment.newInstance())
        }
        binding.cardFundTransfer.setOnClickListener {
            loadFragment(FundTransferFragment.newInstance())
        }
        binding.cardTransactionHistory.setOnClickListener {
            loadFragment(TransactionHistoryFragment.newInstance())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
        refreshBalance()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }
}