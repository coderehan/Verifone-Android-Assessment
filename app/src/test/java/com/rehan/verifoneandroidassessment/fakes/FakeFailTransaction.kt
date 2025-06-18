package com.rehan.verifoneandroidassessment.fakes

import com.rehan.verifoneandroidassessment.data.TransactionService
import com.rehan.verifoneandroidassessment.data.models.Transaction

object FakeFailTransaction : TransactionService {
    override suspend fun getTransactions(): List<Transaction> {
        throw RuntimeException("Transaction API failed")
    }
}