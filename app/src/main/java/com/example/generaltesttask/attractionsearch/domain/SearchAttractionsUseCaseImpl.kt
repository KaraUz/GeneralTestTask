package com.example.generaltesttask.attractionsearch.domain

import com.example.generaltesttask.attractionsearch.data.AttractionRepository
import com.example.generaltesttask.attractionsearch.data.model.Attraction

internal class SearchAttractionsUseCaseImpl(
    val attractionRepository: AttractionRepository
) : SearchAttractionsUseCase {
    override suspend fun invoke(searchQuery: String): Result<List<Attraction>> {
        val filteredAttractions = attractionRepository.getAttractions()
            .getOrNull()
            .orEmpty()

        return Result.success(filteredAttractions)
    }
}
