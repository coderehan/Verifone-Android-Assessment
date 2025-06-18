package com.rehan.verifoneandroidassessment.presentation

import com.rehan.verifoneandroidassessment.domain.DashboardData

sealed class UiState {
    data object Loading : UiState()
    data class Success(val data: DashboardData) : UiState()
    data class Error(val message: String) : UiState()
}