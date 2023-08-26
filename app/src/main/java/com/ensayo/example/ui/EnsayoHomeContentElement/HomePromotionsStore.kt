package com.ensayo.example.ui.EnsayoHomeContentElement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R

@Composable
fun HomePromotionsStore(
    modifier: Modifier = Modifier
){
    Column(
        modifier =modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        OptionsCardSections(
            options = stringResource(id = R.string.element_promociones),

            )
    }
}

@Composable
@Preview
fun HomePromotionsStorePreview(){
    EnsayoTheme {
        HomePromotionsStore()
    }
}