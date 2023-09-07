@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pruebasejercicioensayo.PruebaTopAppBar


import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements.EnsayoHomeOptions
import com.ensayo.example.ui.TopAppBarHomePage.TopBarElements.MainAppBar
import com.ensayo.example.ui.ElementsHomePage.EnsayoListOnlyContent
import com.ensayo.example.ui.TopAppBarHomePage.TopBarElements.RecientsSearchBar
//import com.ensayo.example.ui.EnsayoHomeContentElement.EnsayoTheme
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.barradenavegacion.data.SearchWidgetState
import com.example.barradenavegacion.ui.theme.ViewModelTopBAr
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun PrincipalScreenTopAppBar(
    modifier: Modifier = Modifier
){
    val viewModel: ViewModelTopBAr = viewModel()
    val searchUiState = viewModel.uiState.collectAsState().value
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequestt = remember{FocusRequester()}
    val focusManager = LocalFocusManager.current
    val lazyColumnstate = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val topAppBarState = rememberTopAppBarState()
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

    MainAppBar(
        searchWidgetState = searchUiState.stateSearchBar,
        searchTextState = searchUiState.searchTextState,
        onTextChange = {
            viewModel.updateSearchTextState(newValue = it)
        },
        onCloseClicked = {
            viewModel.updateSearchTextState(newValue = "")
            viewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
            focusManager.clearFocus()

        },
        onSearchClicked = {
            focusRequestt.requestFocus()
            keyboardController?.show()
            viewModel.updateSearchWidgetState(newValue = SearchWidgetState.OPENED)

        },
        scroll = scrollBehavior,
        onSearchClickedTwo = {
            viewModel.updateSearchTextState(newValue = "")
            viewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
            focusManager.clearFocus()

        },
        focusRequester = focusRequestt,
        backArrowClicked = {
            viewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
            focusManager.clearFocus()
            viewModel.updateSearchTextState(newValue = "")

        },
    )
    ContentHomePage(
        lazyListState = lazyColumnstate,
        scrollBehavior = scrollBehavior.nestedScrollConnection,
        barState = searchUiState.stateSearchBar == SearchWidgetState.OPENED
    )
}

@Composable
fun ContentHomePage(
    modifier: Modifier = Modifier,
    scrollBehavior : NestedScrollConnection,
    lazyListState: LazyListState,
    barState: Boolean = true
){
    RecientsSearchBar(
        barState = barState,
    )

    EnsayoListOnlyContent(
        lazyListState =lazyListState ,
        scrollBehavior =scrollBehavior,
    )


}



@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
@Preview
fun PrincipalScreenTopAppBarPreview(){
    EnsayoTheme {
        PrincipalScreenTopAppBar()
    }
}