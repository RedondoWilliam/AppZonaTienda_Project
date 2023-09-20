package com.example.pruebasejercicioensayo.horizontalPagerPage

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ensayo.example.ui.ElementsHomePage.EnsayoListOnlyContent
import com.ensayo.example.ui.ElementsHomePage.EnsayoListOnlyContentPage
import com.ensayo.example.ui.ElementsHomePage.HomePageElements
import com.ensayo.example.ui.ElementsHomePage.navigationPanelControl.ViewModelNavigationPanelControl
import com.ensayo.example.ui.horizontalPagerPage.ViewModelHorizontalPagerPage
import com.ensayo.example.ui.theme.EnsayoTheme
//import com.example.pruebasejercicioensayo.ui.theme.PruebasEjercicioEnsayoTheme

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HorizontalPagerPage(
    modifier: Modifier = Modifier,
    scrollBehavior : TopAppBarScrollBehavior,
    columnState : ScrollState = rememberScrollState(),

    ){
    val viewModelHorizontalPager: ViewModelHorizontalPagerPage = viewModel()
    val horizontalPagerUiState = viewModelHorizontalPager.uiState.collectAsState().value

  val pagerState = rememberPagerState(
      pageCount = {10}
  )
    viewModelHorizontalPager.updateNamePage(newValue =pagerState.currentPage)
   HorizontalPager(
       state = pagerState
   ) {page ->
       when(page){
           0->
           {
               EnsayoListOnlyContentPage(
                   scrollBehavior = scrollBehavior,
                   columnState = columnState
               )
           }
           1,3, 5,7,9 ->
           {
               ScreenShowList(
               pageNumber = page,
               colorBackground = MaterialTheme.colorScheme.onPrimary
               )
           }
           2,4, 6, 8->
           {
               ScreenShowList(
                   pageNumber = page,
                   colorBackground = MaterialTheme.colorScheme.primary
               )
           }

       }

   }
}
//
//@Composable
//@Preview(showBackground = true)
//fun HorizontalPagerPagePreview(){
//    EnsayoTheme {
//        HorizontalPagerPage()
//    }
//}