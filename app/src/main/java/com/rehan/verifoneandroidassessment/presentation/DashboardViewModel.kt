package com.rehan.verifoneandroidassessment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rehan.verifoneandroidassessment.domain.DashboardUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// ViewModel that exposes the dashboard data to the UI. It calls the use case and handles success and error states.
class DashboardViewModel(
    private val useCase: DashboardUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        fetchDashboard()
    }

    private fun fetchDashboard() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val result = useCase.fetchDashboardData()
                _uiState.value = UiState.Success(result)
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Something went wrong: ${e.message}")
            }
        }
    }
}
