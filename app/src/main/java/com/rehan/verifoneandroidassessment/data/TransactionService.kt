package com.rehan.verifoneandroidassessment.data

import com.rehan.verifoneandroidassessment.data.models.Transaction

interface TransactionService {
    suspend fun getTransactions(): List<Transaction>
}