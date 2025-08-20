package com.example.generaltesttask.attractionsearch.domain

import com.example.generaltesttask.attractionsearch.data.AttractionRepository
import com.example.generaltesttask.attractionsearch.data.model.Attraction
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

internal class SearchAttractionsUseCaseImplTest {

    val attractionRepository = mockk<AttractionRepository> {
        coEvery { getAttractions() } returns Result.success(
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

    @Test
    fun `invoke RETURNS attractions sorted by title`() = runTest {
        val searchAttraction = SearchAttractionsUseCaseImpl(attractionRepository)

        val attractions = searchAttraction("").getOrNull().orEmpty()

        assertEquals(attractions[0].title, "Hallstatt")
        assertEquals(attractions[1].title, "Haveby")
        assertEquals(attractions[2].title, "Iseltwald")
        assertEquals(attractions[3].title, "Lauterbrunnen")
        assertEquals(attractions[4].title, "Nida")
        assertEquals(attractions[5].title, "Salzkammergut")
    }
}