package com.rehan.verifoneandroidassessment.fakes

import com.rehan.verifoneandroidassessment.data.ConfigService
import com.rehan.verifoneandroidassessment.data.models.Config

object FakeSuccessConfig : ConfigService {
    override suspend fun getConfig(): Config {
        return Config(
            darkModeEnabled = true,
            currency = "USD"
        )
    }
}

