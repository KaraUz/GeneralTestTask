package com.example.generaltesttask.attractionsearch.data

import com.example.generaltesttask.attractionsearch.data.model.Attraction
import com.example.generaltesttask.attractionsearch.data.network.AttractionService

class AttractionRepositoryImpl(
    val attractionService: AttractionService
) : AttractionRepository {
    var cache: List<Attraction>? = null

    override suspend fun getAttractions(): Result<List<Attraction>> {
        val attractions: List<Attraction> = cache
            ?: attractionService.getAttractions().getOrNull().orEmpty()

        return Result.success(attractions)
    }
}
