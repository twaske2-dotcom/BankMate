package com.example.bankmate

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.bankmate.databinding.ActivityTransactionBinding
import com.example.bankmate.model.AccountRepository
import java.util.Locale

class TransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionBinding

    companion object {
        private const val TAG = "BankMate"
        const val EXTRA_BENEFICIARY_NAME = "extra_beneficiary_name"
        const val EXTRA_ACCOUNT_NUMBER = "extra_account_number"
        const val EXTRA_AMOUNT = "extra_amount"
        const val EXTRA_TRANSFER_MODE = "extra_transfer_mode"

        private const val CHANNEL_ID = "bankmate_transactions_channel"
        private const val NOTIFICATION_ID = 1001
    }

    private val notificationPermissionLauncher =
        registerForActivityResult(androidx.activity.result.contract.ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                showTransactionNotification()
            } else {
                Log.d(TAG, "Notification permission denied by user")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")

        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Only deduct the balance once — guard against double-deduction if
        // this Activity is recreated (e.g. on screen rotation).
        if (savedInstanceState == null) {
            val amount = intent.getDoubleExtra(EXTRA_AMOUNT, 0.0)
            AccountRepository.deduct(amount)
        }

        displayTransactionDetails()
        createNotificationChannel()
        requestNotificationPermissionAndNotify()

        binding.btnDone.setOnClickListener {
            finish()
        }
    }

    private fun displayTransactionDetails() {
        val beneficiaryName = intent.getStringExtra(EXTRA_BENEFICIARY_NAME).orEmpty()
        val accountNumber = intent.getStringExtra(EXTRA_ACCOUNT_NUMBER).orEmpty()
        val amount = intent.getDoubleExtra(EXTRA_AMOUNT, 0.0)
        val transferMode = intent.getStringExtra(EXTRA_TRANSFER_MODE).orEmpty()

        binding.tvBeneficiaryName.text = beneficiaryName
        binding.tvBeneficiaryAccount.text = maskAccountNumber(accountNumber)
        binding.tvAmount.text = String.format(Locale.getDefault(), "₹%,.2f", amount)
        binding.tvTransferMode.text = transferMode
    }

    private fun maskAccountNumber(accountNumber: String): String {
        if (accountNumber.length <= 4) return accountNumber
        val lastFour = accountNumber.takeLast(4)
        return "XXXX$lastFour"
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                getString(R.string.notification_channel_name),
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = getString(R.string.notification_channel_desc)
            }
            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(channel)
        }
    }

    private fun requestNotificationPermissionAndNotify() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            when {
                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED -> {
                    showTransactionNotification()
                }
                else -> {
                    notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
            }
        } else {
            showTransactionNotification()
        }
    }

    private fun showTransactionNotification() {
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_bank_notification)
            .setContentTitle(getString(R.string.notification_title))
            .setContentText(getString(R.string.notification_message))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .build()

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED || Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU
        ) {
            NotificationManagerCompat.from(this).notify(NOTIFICATION_ID, notification)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
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