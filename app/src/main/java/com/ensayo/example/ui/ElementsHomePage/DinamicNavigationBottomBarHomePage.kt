package com.ensayo.example.ui.ElementsHomePage

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ensayo.example.data.NavigationType
import com.ensayo.example.ui.EnsayoApp.EnsayoUiState
import com.ensayo.example.ui.VisitPageElements.VisitPageElements


@Composable
fun DinamicNavigationBottomBarHomePage(
    modifier: Modifier = Modifier,
    ensayoUiState: EnsayoUiState,
    navController: NavHostController = rememberNavController()
){
    when(ensayoUiState.currentEnsayoBoxType){
        NavigationType.INICIO -> HomePageElements(navController = navController)
        NavigationType.VISITA -> VisitPageElements(thisCurrentPage = "Esta es la pantalla de visita")
        NavigationType.CHAD -> VisitPageElements(thisCurrentPage = "Esta es la pantalla de chats")
        NavigationType.POST -> VisitPageElements(thisCurrentPage = "esta es la pantalla de Post")
        NavigationType.MENU -> VisitPageElements(thisCurrentPage = "esta es la pantalla de Menú")
    }
}