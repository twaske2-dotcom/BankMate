package com.example.bankmate.model

/**
 * Simple data model representing a bank transaction.
 * Used both for the simulated Fund Transfer flow and
 * the static Transaction History sample list.
 */
data class Transaction(
    val beneficiaryName: String,
    val accountNumber: String,
    val amount: Double,
    val transferMode: String,
    val status: String = "Successful"
)
