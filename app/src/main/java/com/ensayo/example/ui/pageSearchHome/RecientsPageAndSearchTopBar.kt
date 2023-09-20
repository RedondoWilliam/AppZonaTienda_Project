package com.ensayo.example.ui.pageSearchHome

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ensayo.example.ui.ElementsHomePage.navigationPanelControl.PrincipalNavigationState
import com.ensayo.example.ui.ElementsHomePage.navigationPanelControl.ViewModelNavigationPanelControl
import com.ensayo.example.ui.EnsayoApp.EnsayoApp
import com.ensayo.example.ui.navigationElemenentsSubsections.RoutesSubsections
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.barradenavegacion.data.SearchWidgetState
import com.example.barradenavegacion.ui.theme.ViewModelTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecientsSearchBarPage(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){

    val viewModelNavigation: ViewModelNavigationPanelControl = viewModel()
    val navigationUiState = viewModelNavigation.uiState.collectAsState().value

    val viewModel: ViewModelTopBar = viewModel()
    val searchUiState = viewModel.uiState.collectAsState().value
    val focusManager = LocalFocusManager.current
    val lazyColumnstate = rememberLazyListState()
    val topAppBarState = rememberTopAppBarState()
    var focusRequestt = remember{ FocusRequester() }


    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState,
        canScroll = {true},
        snapAnimationSpec = spring(stiffness = Spring.StiffnessVeryLow),
        flingAnimationSpec = rememberSplineBasedDecay()

    )

    BackHandler(enabled = searchUiState.stateSearchBar == SearchWidgetState.OPENED) {
        navController.popBackStack(RoutesSubsections.HomePage.name, false)
//        viewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
        viewModel.updateSearchTextState(newValue = "")

    }
    RecientsSearchBar(
        searchWidgetState = searchUiState.stateSearchBar,
        searchTextState = searchUiState.searchTextState,
        onTextChange = {
            viewModel.updateSearchTextState(newValue = it)
        },
        onCloseClicked = {
            viewModel.updateSearchTextState(newValue = "")

        },
        scroll =scrollBehavior ,
        onSearchClickedTwo = {
            viewModelNavigation.updateNavigationState(newValue = PrincipalNavigationState.CLOSED)
            viewModel.updateSearchTextState(newValue = "")
            viewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
            focusManager.clearFocus()

        },
        focusRequester = focusRequestt,
        lazyListState = lazyColumnstate,
        scrollBehavior = scrollBehavior.nestedScrollConnection,
        backArrowClicked = {
//            viewModelNavigation.updateNavigationState(newValue = PrincipalNavigationState.CLOSED)
            navController.popBackStack(RoutesSubsections.HomePage.name, false)
            viewModel.updateSearchTextState(newValue = "")
            viewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
            focusManager.clearFocus()
        }
    )

}


