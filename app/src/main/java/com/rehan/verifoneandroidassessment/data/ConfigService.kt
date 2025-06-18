package com.rehan.verifoneandroidassessment.data

import com.rehan.verifoneandroidassessment.data.models.Config

interface ConfigService {
    suspend fun getConfig(): Config
}