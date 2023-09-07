package com.ensayo.example.ui.TopAppBarHomePage.TopBarElements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.barradenavegacion.data.SearchWidgetState


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
        if(searchWidgetState == SearchWidgetState.CLOSED) Modifier.height(0.dp) else Modifier,
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
            containerColor = MaterialTheme.colorScheme.primary
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
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .height(36.dp)
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.width(3.dp))
            BasicTextField(
                value = text,
                onValueChange = {it:String ->
                    ontextchage(it)

                }  ,
                textStyle = TextStyle(
                    MaterialTheme.colorScheme.onSecondaryContainer,
                    fontSize = 16.sp
                ),
                modifier = modifier
                    .fillMaxWidth(0.92f)
                    .padding(4.dp)
                    .background(MaterialTheme.colorScheme.secondaryContainer)
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

            if(text != "" && searchWidgetState == SearchWidgetState.OPENED ){
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onSecondaryContainer,
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
