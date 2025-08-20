package com.example.generaltesttask.attractionsearch.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.generaltesttask.attractionsearch.domain.SearchAttractionsUseCase
import com.example.generaltesttask.attractionsearch.ui.search.model.AttractionSearchUiAction
import com.example.generaltesttask.attractionsearch.ui.search.model.AttractionSearchUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class AttractionSearchViewModel(
    private val searchAttractions: SearchAttractionsUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AttractionSearchUiState())
    val uiState = _uiState.asStateFlow()

    init {
        onSearch("")
    }

    fun onAction(action: AttractionSearchUiAction) {
        when (action) {
            is AttractionSearchUiAction.Search -> onSearch(action.searchQuery)
        }
    }

    private fun onSearch(searchQuery: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val attractions = searchAttractions(searchQuery).getOrNull().orEmpty()
            _uiState.update { it.copy(isLoading = false, attractions = attractions) }
        }
    }
}
