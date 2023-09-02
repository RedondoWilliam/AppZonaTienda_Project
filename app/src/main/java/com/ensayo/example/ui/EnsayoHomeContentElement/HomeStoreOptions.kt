package com.ensayo.example.ui.EnsayoHomeContentElement

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensayo.example.data.local.StoresBottom
import com.ensayo.example.ui.theme.EnsayoTheme

@Composable
fun HomeStoreOptions(
    modifier: Modifier = Modifier
){
   Column(
       modifier = modifier
           .fillMaxWidth(),
   ) {
       Spacer(modifier = Modifier.height(10.dp))
       LazyRow(
           modifier = modifier,
           horizontalArrangement = Arrangement.spacedBy(12.dp)
       ){
           items(StoresBottom.allValuesStoresBotton){ item ->
               Spacer(modifier = Modifier.width(5.dp))
               for (item in StoresBottom.allValuesStoresBotton){
                   OptionsCard(options = stringResource(id = item))
                   Spacer(modifier = Modifier.width(8.dp))
               }
           }

       }
       Spacer(modifier = Modifier.height(10.dp))
       LazyRow(
           horizontalArrangement = Arrangement.spacedBy(12.dp)
       ){
           items(StoresBottom.allValuesStoresBotton){ item ->
               for (
               item in StoresBottom.allValuesStoresBotton[3] .. StoresBottom.allValuesStoresBotton.last()
               ){
                   OptionsCard(options = stringResource(id = item))
                   Spacer(modifier = Modifier.width(8.dp))
               }
           }

       }
       Spacer(modifier = Modifier.height(10.dp))
   }
}

@Composable
@Preview(showBackground = true)
fun HomeStoreOptionsPreview(){
    EnsayoTheme {
        HomeStoreOptions()
    }
}