package com.ensayo.example.ui.topAppBarHomePage.topBarElements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensayo.example.ui.commonElements.textCommonHomePage
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R


/**
 * Esta es una prueba para un cuadro de dialogo
 *
 * @param message El mensaje a mostrar en el cuerpo de diólogo.
 * @param onConfirm La acción a ejecutar cuando se confirme el cuadro de diólogo
 * */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarBody(
    onSearchClicked: () -> Unit,
    scroll: TopAppBarScrollBehavior?,

    ){
    DefaultAppBar(
        scroll = scroll,
        onSearchClicked = onSearchClicked,
    )
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
            textCommonHomePage(
                stringResTextEntry = R.string.suggestnameapp_zonatienda,
                maxLinesResParameter = 1,
                lineHeightParameter = 26.sp,
                fontSizeStyleParameter = 26.sp,
                fontFamilyStyleParameter =MaterialTheme.typography.headlineLarge.fontFamily ,
                colorStyleParameter = MaterialTheme.colorScheme.onBackground
            )

        },
        actions = {
                  ContentActionDefaultAppBar(
                      onSearchClicked = onSearchClicked
                  )
        },
        scrollBehavior = scroll,
    )
}

@Composable
fun ContentActionDefaultAppBar(
    modifier: Modifier = Modifier,
    onSearchClicked: () ->Unit = {}
){
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
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            ProfileImageHome(
                modifier = Modifier.padding(start = 4.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
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
       Surface {
           DefaultAppBar(
               scroll = null,
           )
       }
    }
}

