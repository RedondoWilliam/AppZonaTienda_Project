package com.ensayo.example.ui.ElementsHomePage.navigationPanelControl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ensayo.example.ui.EnsayoApp.EnsayoApp
import com.ensayo.example.ui.navigationElemenentsSubsections.NavigationElementsSubsections
import com.ensayo.example.ui.pageSearchHome.RecientsSearchBarPage
import com.example.barradenavegacion.data.SearchWidgetState
import com.example.barradenavegacion.ui.theme.ViewModelTopBar




@Composable
fun started(){

    val viewModel: ViewModelNavigationPanelControl = viewModel()
    val navigationUiState = viewModel.uiState.collectAsState().value
    if (navigationUiState.statePrincipalNavigation == PrincipalNavigationState.CLOSED){
        EnsayoApp()
    }else{
        RecientsSearchBarPage()
    }
}