package com.example.generaltesttask

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.generaltesttask.attractionsearch.ui.search.AttractionSearchScreen
import kotlinx.serialization.Serializable

@Composable
internal fun AppNavigation(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.AttractionSearch,
        modifier = modifier,
    ) {
        composable<Route.AttractionSearch> {
            AttractionSearchScreen()
        }
    }
}

sealed interface Route {
    @Serializable
    data object AttractionSearch : Route
}
