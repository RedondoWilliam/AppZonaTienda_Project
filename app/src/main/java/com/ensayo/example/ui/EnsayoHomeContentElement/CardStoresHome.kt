package com.ensayo.example.ui.EnsayoHomeContentElement

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R

@Composable
fun CardStoresHome(
    modifier: Modifier = Modifier,
    optionsStore: String
) {
    LazyRow(
        modifier = modifier.padding(start = 8.dp)
    ) {
        item {
            for (i in 1..6) {
                OptionsCardSections(
                    options = optionsStore,
                    maxLines = 7
                )
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}
@Composable
@Preview
fun CardStoresHomePreview(){
    EnsayoTheme {
        CardStoresHome(
            optionsStore =
            stringResource(id = R.string.element_vista_de_tiendas_section_tiendas_cerca)
        )
    }
}