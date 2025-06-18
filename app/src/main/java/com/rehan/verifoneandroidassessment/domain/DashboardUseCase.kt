package com.rehan.verifoneandroidassessment.domain

import com.rehan.verifoneandroidassessment.data.ConfigService
import com.rehan.verifoneandroidassessment.data.ProfileService
import com.rehan.verifoneandroidassessment.data.TransactionService
import kotlinx.coroutines.coroutineScope

// This class is responsible for fetching profile, transactions and config sequentially and returning a combined DashboardData model.
class DashboardUseCase(
    private val profileService: ProfileService,
    private val transactionService: TransactionService,
    private val configService: ConfigService
) {

    // Runs all three API calls sequentially inside a coroutine scope. If any call fails, the whole operation is cancelled.
    suspend fun fetchDashboardData(): DashboardData = coroutineScope {
        // 1. Fetch profile
        val profile = profileService.getProfile()

        // 2. Fetch transactions (only if profile succeeds)
        val transactions = transactionService.getTransactions()

        // 3. Fetch config (only if transactions succeed)
        val config = configService.getConfig()

        // 4. Combine and return DashboardData
        DashboardData(
            profile = profile,
            transactions = transactions,
            config = config
        )
    }
}