package com.ensayo.example.ui

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.GpsFixed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensayo.example.ui.EnsayoHomeContentElement.CardStoresHome
import com.ensayo.example.ui.EnsayoHomeContentElement.DescriptionSectionCard
import com.ensayo.example.ui.EnsayoHomeContentElement.EnsayoHomeOptions
//import com.ensayo.example.ui.EnsayoHomeContentElement.EnsayoHomeTopBar
import com.ensayo.example.ui.EnsayoHomeContentElement.HomePromotionsStore
import com.ensayo.example.ui.EnsayoHomeContentElement.HomeStoreOptions
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnsayoListOnlyContent(
//    ensayoUiState: EnsayoUiState,
    modifier: Modifier = Modifier,
    lazyListState: LazyListState,
    scrollBehavior : NestedScrollConnection,
){
//    val elements = ensayoUiState.descriptionCurrentScreen
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        LazyColumn(
            state = lazyListState,
            modifier = modifier
                .fillMaxWidth()
                .nestedScroll(connection = scrollBehavior)
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.list_homapage_vertical_spacing )
            )
        ){
            item {
                EnsayoHomeOptions()
            }
            item {
                HomeStoreOptions()
            }
            item {
                DescriptionSectionCard(
                    options = stringResource(id = R.string.element_tiendas_cerca)
                )
            }
            item {
                CardStoresHome(
                    optionsStore = stringResource(
                        id = R.string.element_vista_de_tiendas_section_tiendas_cerca
                    )
                )
            }
            item {
                DescriptionSectionCard(
                    options = stringResource(id = R.string.element_sugerido_para_ti)
                )
            }
            item {
                CardStoresHome(
                    optionsStore = stringResource(
                        id = R.string.element_vista_de_tiendas_section_sugerido_para_ti
                    )
                )
            }
            item {
                HomePromotionsStore()
            }
            item {
                DescriptionSectionCard(
                    options = stringResource(id = R.string.element_tiendas_cerca)
                )
            }
            item {
                CardStoresHome(
                    optionsStore = stringResource(
                        id = R.string.element_vista_de_tiendas_section_tiendas_cerca
                    )
                )
            }
            item {
                DescriptionSectionCard(
                    options = stringResource(id = R.string.element_sugerido_para_ti)
                )
            }
            item {
                CardStoresHome(
                    optionsStore = stringResource(
                        id = R.string.element_vista_de_tiendas_section_sugerido_para_ti
                    )
                )
            }
            item {
                HomePromotionsStore()
            }
        }

        FloatingActionBottonScreen()

    }

}

@Composable
fun FloatingActionBottonScreen(
    modifier: Modifier = Modifier
){
    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .offset((-10).dp, -10.dp)
            .clip(CircleShape),
        shape = shapes.large
    ) {
        Icon(
            imageVector = Icons.Default.AddBox,
            contentDescription = null,
        )
    }
    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .offset((-10).dp, -80.dp)
            .clip(CircleShape),
        shape = shapes.large
    ) {
        Icon(
            imageVector = Icons.Default.AddAPhoto,
            contentDescription = null,
        )
    }
    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .offset((-10).dp, -150.dp)
            .clip(CircleShape),
        shape = shapes.large
    ) {
        Icon(
            imageVector = Icons.Default.GpsFixed,
            contentDescription = null,
        )
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
            scrollBehavior = scrollBehavior.nestedScrollConnection
        )
    }
}
