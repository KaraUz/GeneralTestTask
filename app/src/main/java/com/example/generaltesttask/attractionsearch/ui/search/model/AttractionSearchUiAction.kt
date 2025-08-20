package com.example.generaltesttask.attractionsearch.ui.search.model

internal sealed interface AttractionSearchUiAction {
    data class Search(val searchQuery: String) : AttractionSearchUiAction
}
