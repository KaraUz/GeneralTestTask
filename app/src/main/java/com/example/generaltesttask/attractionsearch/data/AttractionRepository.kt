package com.example.generaltesttask.attractionsearch.data

import com.example.generaltesttask.attractionsearch.data.model.Attraction

interface AttractionRepository {
    suspend fun getAttractions(): Result<List<Attraction>>
}
