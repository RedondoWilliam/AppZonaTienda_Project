package com.ensayo.example.ui.EnsayoApp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ensayo.example.data.NavigationType
import com.ensayo.example.ui.ElementsHomePage.EnsayoHomeScreen
import com.ensayo.example.ui.navigationElemenentsSubsections.NavigationElementsSubsections

@Composable
fun EnsayoApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
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
        modifier = modifier,
        navController = navController
    )

}