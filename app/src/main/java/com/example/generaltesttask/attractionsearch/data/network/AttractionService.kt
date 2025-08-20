package com.example.generaltesttask.attractionsearch.data.network

import com.example.generaltesttask.attractionsearch.data.model.Attraction

interface AttractionService {
    suspend fun getAttractions(): Result<List<Attraction>>
}
