package com.rehan.verifoneandroidassessment.domain

import com.rehan.verifoneandroidassessment.data.models.Config
import com.rehan.verifoneandroidassessment.data.models.Profile
import com.rehan.verifoneandroidassessment.data.models.Transaction

data class DashboardData(
    val profile: Profile,
    val transactions: List<Transaction>,
    val config: Config
)