package com.ensayo.example.ui.TopAppBarHomePage.TopBarElements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.barradenavegacion.data.SearchWidgetState
import com.example.ensayo.R


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
    if(searchWidgetState == SearchWidgetState.CLOSED){
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
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        title = {
            Text(
                text = "ZonaTienda",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.headlineLarge
            )

        },
        actions = {
           Row(
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically
           ) {
               IconButton(
                   onClick = onSearchClicked
               ) {
                   Icon(
                       painter = painterResource(id = R.drawable.humbleicons_search),
                       contentDescription = "Search Icon",
                       tint = MaterialTheme.colorScheme.onBackground,
                   )
               }
               IconButton(
                   onClick = {}
               ) {
                   Icon(
                       painter = painterResource(id = R.drawable.mingcute_notification_line),
                       contentDescription = "Search Icon",
                       tint = MaterialTheme.colorScheme.onBackground
                   )
               }
               IconButton(
                   onClick = {}
               ) {
                   Icon(
                       painter = painterResource(id = R.drawable.heart),
                       contentDescription = "Search Icon",
                       tint = MaterialTheme.colorScheme.onBackground
                   )
               }
               ProfileImage(
                   modifier = modifier.padding(start = 4.dp)
               )
               Spacer(modifier = Modifier.width(8.dp))
           }

        },
        scrollBehavior = scroll,
    )
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
       Surface {
           DefaultAppBar(
               scroll = null,
           )
       }
    }
}

