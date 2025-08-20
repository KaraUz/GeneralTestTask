package com.example.generaltesttask.attractionsearch.ui.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.generaltesttask.attractionsearch.data.model.Attraction
import com.example.generaltesttask.attractionsearch.ui.search.model.AttractionSearchUiAction
import com.example.generaltesttask.attractionsearch.ui.search.model.AttractionSearchUiState
import com.example.generaltesttask.ui.theme.GeneralTestTaskTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun AttractionSearchScreen(
    modifier: Modifier = Modifier,
    viewModel: AttractionSearchViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AttractionSearchScreenContent(
        uiState = uiState,
        onAction = viewModel::onAction,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AttractionSearchScreenContent(
    uiState: AttractionSearchUiState,
    onAction: (AttractionSearchUiAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    val textFieldState = remember { TextFieldState() }
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier
            .fillMaxSize()
            .semantics { isTraversalGroup = true },
    ) {
        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .semantics { traversalIndex = 0f },
            inputField = {
                SearchBarDefaults.InputField(
                    query = textFieldState.text.toString(),
                    onQueryChange = { textFieldState.edit { replace(0, length, it) } },
                    onSearch = {
                        onAction(AttractionSearchUiAction.Search(textFieldState.text.toString()))
                    },
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    placeholder = { Text("Search") }
                )
            },
            expanded = expanded,
            onExpandedChange = { expanded = it },
        ) {
            LazyColumn(
                contentPadding = WindowInsets.navigationBars.asPaddingValues()
            ) {
                items(uiState.attractions) { attraction ->
                    AttractionItem(attraction = attraction)
                }
            }
        }
    }
}

@Composable
private fun AttractionItem(
    attraction: Attraction,
    modifier: Modifier = Modifier,
) {
    ListItem(
        headlineContent = { Text(attraction.title) },
        modifier = modifier
            .fillMaxWidth()
    )
}

@Preview
@Composable
private fun AttractionSearchScreenContentPreview() {
    GeneralTestTaskTheme {
        AttractionSearchScreenContent(
            uiState = AttractionSearchUiState(),
            onAction = {},
        )
    }
}
