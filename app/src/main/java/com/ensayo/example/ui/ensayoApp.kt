package com.ensayo.example.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ensayo.example.data.NavigationType

@Composable
fun EnsayoApp(
    modifier: Modifier = Modifier
) {
    val viewModel : EnsayoViewModel = viewModel()
    val ensayoUiState = viewModel.uiState.collectAsState().value

    EnsayoHomeScreen(
        ensayoUiState = ensayoUiState ,
        onTapPressed = {navigationType: NavigationType ->
            viewModel.updateCurrentEnsayoBox(navigationType = navigationType)
            viewModel.resetHomeScreensStates()

        },
        onSectionScreenTabPressed = {},
        modifier = modifier
    )
}