package com.example.generaltesttask

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.generaltesttask.ui.theme.GeneralTestTaskTheme

@Composable
internal fun App() {
    GeneralTestTaskTheme {
        AppNavigation(modifier = Modifier.fillMaxSize())
    }
}
