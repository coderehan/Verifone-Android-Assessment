package com.rehan.verifoneandroidassessment.fakes

import com.rehan.verifoneandroidassessment.data.TransactionService
import com.rehan.verifoneandroidassessment.data.models.Transaction

object FakeSuccessTransaction : TransactionService {
    override suspend fun getTransactions(): List<Transaction> {
        return listOf(
            Transaction(
                id = "transaction1",
                amount = 100.0,
                date = "2025-06-01"
            )
        )
    }
}
