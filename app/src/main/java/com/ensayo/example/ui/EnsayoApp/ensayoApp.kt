package com.ensayo.example.ui.EnsayoApp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ensayo.example.data.NavigationType
import com.ensayo.example.ui.ElementsHomePage.EnsayoHomeScreen

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