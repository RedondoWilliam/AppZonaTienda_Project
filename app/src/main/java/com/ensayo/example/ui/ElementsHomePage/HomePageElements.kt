package com.ensayo.example.ui.ElementsHomePage

import PrincipalScreenTopAppBar
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements.EnsayoHomeOptions
import com.example.barradenavegacion.data.SearchWidgetState
import com.example.barradenavegacion.ui.theme.ViewModelTopBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
 fun HomePageElements(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    val viewModel: ViewModelTopBar = viewModel()
    val searchUiState = viewModel.uiState.collectAsState().value
    val lazyColumnstate = rememberLazyListState()
    val topAppBarState = rememberTopAppBarState()
    val columnState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState,
        canScroll = {true},
        snapAnimationSpec = spring(stiffness = Spring.StiffnessVeryLow),
        flingAnimationSpec = rememberSplineBasedDecay()

    )

    BackHandler(enabled = searchUiState.stateSearchBar == SearchWidgetState.OPENED) {
        viewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
        viewModel.updateSearchTextState(newValue = "")

    }
    BackHandler(enabled = searchUiState.stateSearchBar == SearchWidgetState.CLOSED) {
        coroutineScope.launch {
            withContext(Dispatchers.Main){
                lazyColumnstate.animateScrollToItem(index = 0)
                scrollBehavior.state.heightOffset = 0f
            }
        }
    }

    Column(
    ) {
        PrincipalScreenTopAppBar(
            scroll = scrollBehavior,
            navController = navController
        )
        EnsayoHomeOptions()
        EnsayoListOnlyContent(
            lazyListState = lazyColumnstate,
            scrollBehavior =scrollBehavior,
            columnState = columnState
        )
    }
}