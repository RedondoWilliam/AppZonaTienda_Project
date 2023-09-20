package com.ensayo.example.ui.pageSearchHome

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.DoubleArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ensayo.example.ui.commonElements.textCommonHomePage
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.barradenavegacion.data.SearchWidgetState
import com.example.barradenavegacion.ui.theme.ViewModelTopBar
import com.example.ensayo.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecientsSearchBar(
    modifier: Modifier = Modifier,
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    scroll: TopAppBarScrollBehavior?,
    onSearchClickedTwo: (String) -> Unit,
    focusRequester: FocusRequester,
    backArrowClicked: () -> Unit = {},
    lazyListState: LazyListState,
    scrollBehavior : NestedScrollConnection,
){
    Column {
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
        ContentLazyColumnSearchAppBar(
            lazyListState = lazyListState,
            scrollBehavior = scrollBehavior
        )
    }

}



@Composable
fun ContentLazyColumnSearchAppBar(
    modifier: Modifier = Modifier,
    lazyListState: LazyListState,
    scrollBehavior : NestedScrollConnection,
){
    LazyColumn(
        state = lazyListState,
        modifier = modifier
            .nestedScroll(connection = scrollBehavior)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ){
        item {
            RecientsSearchCard(
                composable =  RecientsSearchRowTitle()
            )
        }
        item {
            for (i in 1..10){
                RecientsSearchCard(
                    composable =  RecientsSearchRow()
                )
            }
        }
    }
}




@Composable
fun RecientsSearchCard(
    modifier: Modifier = Modifier,
    composable: Unit
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 8.dp, top = 10.dp, bottom = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
       composable
    }
}

@Composable
fun RecientsSearchRow(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Icon(
                imageVector = Icons.Default.AccessTime,
                contentDescription = "Search Icon",
                tint = MaterialTheme.colorScheme.onBackground

            )
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = "tiendas cerca de casa",
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Icon(
            imageVector = Icons.Default.DoubleArrow,
            contentDescription = "Search Icon",
            tint = MaterialTheme.colorScheme.onBackground,


        )

    }
}


@Composable
fun RecientsSearchRowTitle(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        textCommonHomePage(
            stringResTextEntry = R.string.recientes,
            maxLinesResParameter = 1,
            lineHeightParameter = 12.sp,
            fontSizeStyleParameter = 12.sp,
            fontFamilyStyleParameter =
            FontFamily(
                Font(R.font.raleway_bold, FontWeight.Bold)
            ),
            colorStyleParameter = MaterialTheme.colorScheme.onBackground
        )
        Icon(
            imageVector = Icons.Default.AccessTime,
            contentDescription = "Search Icon",
            tint = MaterialTheme.colorScheme.onBackground,


            )

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun RecientsSearchBarPreview(){
    val lazyColumnstate = rememberLazyListState()
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState,
        canScroll = {true},
        snapAnimationSpec = spring(stiffness = Spring.StiffnessVeryLow),
        flingAnimationSpec = rememberSplineBasedDecay()

    )
    EnsayoTheme {
        ContentLazyColumnSearchAppBar(
            lazyListState = lazyColumnstate,
            scrollBehavior = scrollBehavior.nestedScrollConnection
        )
    }
}

@Composable
@Preview(showBackground = true)
fun RecientsSearchCardPreview(){
    EnsayoTheme {
        RecientsSearchCard(
            composable =  RecientsSearchRow()
        )
    }
}

@Composable
@Preview(showBackground = true)
fun RecientsSearchRowPreview(){
    EnsayoTheme {

    }
}

@Composable
@Preview(showBackground = true)
fun RecientsSearchRowTitlePreview(){
    EnsayoTheme {
        RecientsSearchRowTitle()
    }
}

