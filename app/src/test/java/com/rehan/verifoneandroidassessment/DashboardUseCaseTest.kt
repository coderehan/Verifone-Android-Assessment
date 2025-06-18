package com.rehan.verifoneandroidassessment

import com.rehan.verifoneandroidassessment.domain.DashboardData
import com.rehan.verifoneandroidassessment.domain.DashboardUseCase
import com.rehan.verifoneandroidassessment.fakes.FakeSuccessProfile
import com.rehan.verifoneandroidassessment.fakes.FakeSuccessTransaction
import com.rehan.verifoneandroidassessment.fakes.FakeFailTransaction
import com.rehan.verifoneandroidassessment.fakes.FakeSuccessConfig
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Test

class DashboardUseCaseTest {

    @Test
    fun `test success flow returns DashboardData`() = runTest {
        val useCase = DashboardUseCase(FakeSuccessProfile, FakeSuccessTransaction, FakeSuccessConfig)
        val result = useCase.fetchDashboardData()

        assertNotNull(result)
        assertTrue(true)
        assertEquals("Test User", result.profile.name)
        assertEquals(1, result.transactions.size)
        assertEquals("USD", result.config.currency)
    }

    @Test(expected = RuntimeException::class)
    fun `test failure in transaction call throws exception`() = runTest {
        val useCase = DashboardUseCase(FakeSuccessProfile, FakeFailTransaction, FakeSuccessConfig)
        useCase.fetchDashboardData()
    }
}