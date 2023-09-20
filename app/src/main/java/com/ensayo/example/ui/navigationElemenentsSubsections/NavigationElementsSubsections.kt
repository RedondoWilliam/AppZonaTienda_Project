package com.ensayo.example.ui.navigationElemenentsSubsections

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ensayo.example.ui.EnsayoApp.EnsayoApp
import com.ensayo.example.ui.pageSearchHome.RecientsSearchBarPage


enum class RoutesSubsections(){
    SearachPage, HomePage

}


@Composable
fun NavigationElementsSubsections(
    modifier: Modifier = Modifier
){

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RoutesSubsections.HomePage.name,
    ){
        composable(route = RoutesSubsections.SearachPage.name){
            RecientsSearchBarPage(
                navController = navController
            )
        }
        composable(route = RoutesSubsections.HomePage.name){
            EnsayoApp(
                navController = navController
            )
        }
    }


}