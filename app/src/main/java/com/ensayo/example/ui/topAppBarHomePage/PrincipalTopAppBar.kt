import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ensayo.example.ui.ElementsHomePage.navigationPanelControl.PrincipalNavigationState
import com.ensayo.example.ui.ElementsHomePage.navigationPanelControl.ViewModelNavigationPanelControl
import com.ensayo.example.ui.navigationElemenentsSubsections.RoutesSubsections
import com.ensayo.example.ui.topAppBarHomePage.topBarElements.TopAppBarBody
import com.example.barradenavegacion.data.SearchWidgetState
import com.example.barradenavegacion.ui.theme.ViewModelTopBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun PrincipalScreenTopAppBar(
    modifier: Modifier = Modifier,
    scroll: TopAppBarScrollBehavior?,
    navController: NavHostController = rememberNavController()

){
    val viewModelNavigation: ViewModelNavigationPanelControl = viewModel()
    val navigationUiState = viewModelNavigation.uiState.collectAsState().value

    val viewModel: ViewModelTopBar = viewModel()
    val searchUiState = viewModel.uiState.collectAsState().value
    val focusManager = LocalFocusManager.current
//    val lazyColumnstate = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val activity = LocalContext.current as? Activity
    val topAppBarState = rememberTopAppBarState()
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
//        state = topAppBarState,
//        canScroll = {true},
//        snapAnimationSpec = spring(stiffness = Spring.StiffnessVeryLow),
//        flingAnimationSpec = rememberSplineBasedDecay()
//
//    )
//    BackHandler(enabled = searchUiState.stateSearchBar == SearchWidgetState.OPENED) {
//        viewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
//        viewModel.updateSearchTextState(newValue = "")
//
//    }
//    BackHandler(enabled = searchUiState.stateSearchBar == SearchWidgetState.CLOSED) {
//        coroutineScope.launch {
//            withContext(Dispatchers.Main){
//                lazyListState.animateScrollToItem(index = 0)
//                scrollBehavior.state.heightOffset = 0f
//            }
//        }
//    }
    TopAppBarBody(
        onSearchClicked = {
            navController.navigate(RoutesSubsections.SearachPage.name)
            viewModel.updateSearchWidgetState(newValue = SearchWidgetState.OPENED)
//            viewModelNavigation.updateNavigationState(newValue = PrincipalNavigationState.OPENED)

        },
        scroll = scroll,
    )
}
