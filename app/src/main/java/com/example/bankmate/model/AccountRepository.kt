package com.example.bankmate.model

object AccountRepository {

    private const val STARTING_BALANCE = 50000.0

    var balance: Double = STARTING_BALANCE
        private set

    fun deduct(amount: Double) {
        balance = (balance - amount).coerceAtLeast(0.0)
    }

    fun hasSufficientBalance(amount: Double): Boolean = amount <= balance
}