package com.example.generaltesttask.attractionsearch.ui.search.model

import com.example.generaltesttask.attractionsearch.data.model.Attraction

internal data class AttractionSearchUiState(
    val isLoading: Boolean = true,
    val attractions: List<Attraction> = emptyList(),
)
