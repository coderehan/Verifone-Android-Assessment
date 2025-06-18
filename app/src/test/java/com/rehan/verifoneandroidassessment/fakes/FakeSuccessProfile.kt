package com.rehan.verifoneandroidassessment.fakes

import com.rehan.verifoneandroidassessment.data.ProfileService
import com.rehan.verifoneandroidassessment.data.models.Profile

object FakeSuccessProfile : ProfileService {
    override suspend fun getProfile(): Profile {
        return Profile(id = "1", name = "Test User")
    }
}

