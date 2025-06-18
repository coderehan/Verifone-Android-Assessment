package com.rehan.verifoneandroidassessment.data

import com.rehan.verifoneandroidassessment.data.models.Profile

interface ProfileService {
    suspend fun getProfile(): Profile
}