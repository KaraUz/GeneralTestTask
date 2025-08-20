package com.example.generaltesttask.attractionsearch.domain

import com.example.generaltesttask.attractionsearch.data.model.Attraction

internal fun interface SearchAttractionsUseCase {
    suspend operator fun invoke(searchQuery: String): Result<List<Attraction>>
}
