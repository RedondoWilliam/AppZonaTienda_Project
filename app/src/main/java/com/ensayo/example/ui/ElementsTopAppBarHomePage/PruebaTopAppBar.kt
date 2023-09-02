@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pruebasejercicioensayo.PruebaTopAppBar


import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ensayo.example.ui.ElementsTopAppBarHomePage.ProfileImage
import com.ensayo.example.ui.EnsayoListOnlyContent
//import com.ensayo.example.ui.EnsayoHomeContentElement.EnsayoTheme
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.barradenavegacion.data.SearchWidgetState
import com.example.barradenavegacion.ui.theme.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun PrincipalScreenTopAppBar(
    modifier: Modifier = Modifier
){
    val viewModel: MainViewModel = viewModel()
    val searchUiState = viewModel.uiState.collectAsState().value
    val keyboardController = LocalSoftwareKeyboardController.current
    var focusRequestt = remember{FocusRequester()}
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

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)

    ){

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


/**
 * Esta es una prueba para un cuadro de dialogo
 *
 * @param message El mensaje a mostrar en el cuerpo de diólogo.
 * @param onConfirm La acción a ejecutar cuando se confirme el cuadro de diólogo
 * */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: () -> Unit,
    scroll: TopAppBarScrollBehavior?,
    onSearchClickedTwo: (String) -> Unit,
    focusRequester: FocusRequester,
    backArrowClicked: () -> Unit = {},

){
   if(searchWidgetState ==SearchWidgetState.CLOSED){
       DefaultAppBar(
           scroll = scroll,
           onSearchClicked = onSearchClicked,


       )
   }
    DefaultAppBarSearch(
        scroll = scroll,
        searchWidgetState = searchWidgetState,
        text = searchTextState,
        ontextchage = onTextChange,
        onCloseClicked = onCloseClicked,
        onSearchClickedTwo = onSearchClickedTwo,
        focusRequester = focusRequester,
        backArrowClicked = backArrowClicked,
    )
}

@Composable
fun FirstItemPrincipalScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier.fillMaxWidth(),
    ) {
        for( i in 1..2){
            Card(
                modifier = modifier
                    .height(50.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "esto es una prueba ${i}")
            }
            Spacer(modifier = modifier.height(20.dp))
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBar(
    modifier: Modifier = Modifier,
    onSearchClicked: () ->Unit = {},
    scroll: TopAppBarScrollBehavior?,
){

    TopAppBar(
        modifier = Modifier,
        title = {
            Text(
                text = "ZonaTienda",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.headlineLarge
            )

        },
        actions = {
            IconButton(
                onClick = onSearchClicked
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Black,
                )
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Search Icon",
                    tint = Color.Black
                )
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = "Search Icon",
                    tint = Color.Black
                )
            }
            ProfileImage()
            Spacer(modifier = Modifier.width(8.dp))

        },
        scrollBehavior = scroll,
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBarSearch(
    searchWidgetState: SearchWidgetState,
    modifier: Modifier = Modifier,
    scroll: TopAppBarScrollBehavior?,
    text: String,
    ontextchage: (String) -> Unit,
    onCloseClicked : () -> Unit,
    onSearchClickedTwo: (String) -> Unit,
    backArrowClicked: () -> Unit = {},
    focusRequester: FocusRequester,
){
    TopAppBar(
        modifier =
        if(searchWidgetState ==SearchWidgetState.CLOSED) Modifier.height(0.dp) else Modifier,
        title = {
        },
        actions = {
            SearchAppBar(
                text = text,
                ontextchage = ontextchage,
                onCloseClicked = onCloseClicked,
                onSearchClicked = onSearchClickedTwo,
                focusRequester = focusRequester,
                searchWidgetState = searchWidgetState,
                modifier = Modifier.fillMaxWidth(0.92f)
            )
        },
        scrollBehavior = scroll,
        navigationIcon = {
            IconButton(
                modifier = modifier
                    .fillMaxWidth(0.1f)
                    .size(24.dp)
                    .padding(start = 8.dp),
                onClick =  backArrowClicked
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Search Icon",
                    tint = Color.Black
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}

@Composable
fun SearchAppBar(
    searchWidgetState: SearchWidgetState,
    modifier: Modifier = Modifier,
    text: String,
    ontextchage: (String) -> Unit,
    onCloseClicked : () -> Unit,
    onSearchClicked: (String) -> Unit,
    focusRequester: FocusRequester
){
   Box(
       modifier = modifier
           .wrapContentSize()
   ) {
       Row(
           modifier = modifier
               .clip(CircleShape)
               .background(Color.Gray)
               .height(36.dp)
               .padding(start = 16.dp, end = 16.dp)
               .fillMaxWidth(),
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceBetween
       ) {
           Icon(
               imageVector = Icons.Default.Search,
               contentDescription = "",
               tint = Color.White
           )
           Spacer(modifier = Modifier.width(3.dp))
           BasicTextField(
               value = text,
               onValueChange = {it:String ->
                   ontextchage(it)

               }  ,
               textStyle = TextStyle(
                   Color.White,
                   fontSize = 16.sp
               ),
               modifier = modifier
                   .fillMaxWidth(0.92f)
                   .padding(4.dp)
                   .background(Color.Gray)
                   .focusRequester(focusRequester),
               keyboardOptions = KeyboardOptions(
                   imeAction = ImeAction.Search
               ),
               keyboardActions = KeyboardActions(
                   onSearch = {
                       onSearchClicked(text)
                   }
               ),
               singleLine = true,
               enabled = true,

           )

           if(text != "" && searchWidgetState ==SearchWidgetState.OPENED ){
               Icon(
                   imageVector = Icons.Default.Close,
                   contentDescription = "",
                   tint = Color.White,
                   modifier = Modifier
                       .clickable {
                           if (text.isNotEmpty()) {
                               ontextchage("")
                           } else {
                               onCloseClicked()
                           }
                       }
                       .width(25.dp)
               )
           }else{
               Spacer(modifier = Modifier.width(25.dp))
           }
       }
       if(text == ""){
           Text(
               text = "Buscar...",
               modifier = modifier
                   .offset(x = 52.dp, y = 8.1.dp ),
               fontSize = 16.sp,
               color = Color.White
           )
       }
   }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun DefaultAppBarPreview(){

    EnsayoTheme {
        DefaultAppBar(
            scroll = null,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun DefaultAppBarOpenPreview(){

    EnsayoTheme {
        DefaultAppBar(
            scroll = null,
        )
    }
}

@Composable
@Preview
fun SearchAppBarPreview() {

    EnsayoTheme {
        SearchAppBar(
            searchWidgetState = SearchWidgetState.OPENED,
            text = "hola",
            ontextchage = {} ,
            onCloseClicked = { /*TODO*/ },
            onSearchClicked = {} ,
            focusRequester = FocusRequester()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun DefaultAppBarSearchPreview(){
    EnsayoTheme {
        DefaultAppBarSearch(
            searchWidgetState = SearchWidgetState.OPENED ,
            scroll = null,
            text = "" ,
            ontextchage = {},
            onCloseClicked = { /*TODO*/ },
            onSearchClickedTwo = {},
            focusRequester = FocusRequester()
        )
    }
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