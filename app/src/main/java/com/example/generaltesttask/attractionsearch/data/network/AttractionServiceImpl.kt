package com.example.generaltesttask.attractionsearch.data.network

import com.example.generaltesttask.attractionsearch.data.model.Attraction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class AttractionServiceImpl : AttractionService {
    override suspend fun getAttractions(): Result<List<Attraction>> {
        return withContext(Dispatchers.IO) {
            delay(3000L)
            Result.success(
                listOf(
                    Attraction(title = "Hallstatt", country = "Austria", id = 0),
                    Attraction(title = "Haveby", country = "Denmark", id = 1),
                    Attraction(title = "Iseltwald", country = "Switzerland", id = 2),
                    Attraction(title = "Salzkammergut", country = "Austria", id = 3),
                    Attraction(title = "Lauterbrunnen", country = "Switzerland", id = 4),
                    Attraction(title = "Nida", country = "Lithuania", id = 5),
                )
            )
        }
    }
}
