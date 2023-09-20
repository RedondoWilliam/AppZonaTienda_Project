package com.ensayo.example.ui.ElementsHomePage

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.GpsFixed
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements.ContentSectionNearStore
//import com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements.CardStoresHome
import com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements.DescriptionSectionCard
import com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements.EnsayoHomeOptions
import com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements.FloatingActionBottonScreen
//import com.ensayo.example.ui.EnsayoHomeContentElement.EnsayoHomeTopBar
import com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements.HomePromotionsStore
import com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements.HomeStoreOptions
import com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements.HomeSuggestForYou
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R
import com.example.pruebasejercicioensayo.horizontalPagerPage.HorizontalPagerPage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnsayoListOnlyContent(
//    ensayoUiState: EnsayoUiState,
    modifier: Modifier = Modifier,
    lazyListState: LazyListState,
    scrollBehavior : TopAppBarScrollBehavior,
    columnState : ScrollState = rememberScrollState(),
){
//    val elements = ensayoUiState.descriptionCurrentScreen
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomEnd
    ) {
        HorizontalPagerPage(
            scrollBehavior = scrollBehavior,
            columnState = columnState
        )
        FloatingActionBottonScreen()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnsayoListOnlyContentPage(
    modifier: Modifier = Modifier,
    scrollBehavior : TopAppBarScrollBehavior,
    columnState : ScrollState = rememberScrollState(),
){
    Column(
//            state = lazyListState,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.background)
            .nestedScroll(connection = scrollBehavior.nestedScrollConnection)
            .verticalScroll(columnState)
            ,
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.list_homapage_vertical_spacing )
        )
    ){


        DescriptionSectionCard(options = R.string.principal)
        HomeStoreOptions()
        DescriptionSectionCard(
            options =R.string.element_tiendas_cerca
        )
        ContentSectionNearStore()
        DescriptionSectionCard(
            options = R.string.element_sugerido_para_ti
        )
        HomeSuggestForYou()
        HomePromotionsStore(image = R.drawable.promotions)
        HomePromotionsStore(
            image = R.drawable.promociones
        )
        HomePromotionsStore(
            image = R.drawable.imagetwo
        )


//            item(key = 111) {
//                EnsayoHomeOptions()
//            }
//            item(key = 112)  {
//                Divider(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 3.dp)
//                )
//            }
//            item(key = 113)  {
//                DescriptionSectionCard(options = R.string.principal)
//            }
//            item(key = 114) {
//                HomeStoreOptions()
//            }
//            item(key = 115) {
//                DescriptionSectionCard(
//                    options =R.string.element_tiendas_cerca
//                )
//            }
//            item(key = 116) {
//                ContentSectionNearStore()
//            }
//            item(key = 117) {
//                HomePromotionsStore(
//                    image = R.drawable.promociones
//                )
//            }
//            item(key = 118) {
//                HomePromotionsStore(
//                    image = R.drawable.imagetwo
//                )
//            }
//            item(key = 119) {
//                DescriptionSectionCard(
//                    options = R.string.element_sugerido_para_ti
//                )
//            }
//            item(key = 119.1) {
//                HomeSuggestForYou()
//            }


//            item(key = 1110) {
//                ContentSectionNearStore()
//            }

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun EnsayoListOnlyContentPreview(){
    EnsayoTheme(darkTheme = false) {
        val lazyColumnstate = rememberLazyListState()
        val topAppBarState = rememberTopAppBarState()
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
            state = topAppBarState,
            canScroll = {true},
            snapAnimationSpec = spring(stiffness = Spring.StiffnessVeryLow),
            flingAnimationSpec = rememberSplineBasedDecay()

        )
        EnsayoListOnlyContent(
            lazyListState = lazyColumnstate,
            scrollBehavior = scrollBehavior
        )
    }
}
