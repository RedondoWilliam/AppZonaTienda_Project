package com.example.pruebasejercicioensayo.PruebaTopAppBar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.DoubleArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensayo.example.ui.theme.EnsayoTheme

//import com.example.pruebasejercicioensayo.ui.theme.PruebasEjercicioEnsayoTheme

@Composable
fun RecientsSearchBar(
    modifier: Modifier = Modifier,
    barState: Boolean = true
){
    AnimatedVisibility(
        visible =barState,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        LazyColumn(
            modifier = modifier.fillMaxSize()
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
            containerColor = MaterialTheme.colorScheme.background
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
                tint = Color.Black

            )
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = "tiendas cerca de casa"
            )
        }
        Icon(
            imageVector = Icons.Default.DoubleArrow,
            contentDescription = "Search Icon",
            tint = Color.Black,


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
        Text(
            text = "Recientes",
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(start = 4.dp, end = 5.dp, top = 16.dp, bottom = 16.dp)
        )
        Icon(
            imageVector = Icons.Default.AccessTime,
            contentDescription = "Search Icon",
            tint = Color.Black,


            )

    }
}


@Composable
@Preview(showBackground = true)
fun RecientsSearchBarPreview(){
    EnsayoTheme {
        RecientsSearchBar()
    }
}

@Composable
@Preview
fun RecientsSearchCardPreview(){
    EnsayoTheme {
        RecientsSearchCard(
            composable =  RecientsSearchRow()
        )
    }
}

@Composable
@Preview
fun RecientsSearchRowPreview(){
    EnsayoTheme {
        
    }
}

@Composable
@Preview
fun RecientsSearchRowTitlePreview(){
    EnsayoTheme {
        RecientsSearchRowTitle()
    }
}

