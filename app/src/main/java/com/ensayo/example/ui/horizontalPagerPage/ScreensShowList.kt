package com.example.pruebasejercicioensayo.horizontalPagerPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ensayo.example.ui.theme.EnsayoTheme
//import com.example.pruebasejercicioensayo.ui.theme.PruebasEjercicioEnsayoTheme

@Composable
fun ScreenShowList(
    modifier: Modifier = Modifier,
    pageNumber: Int,
    colorBackground : Color
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colorBackground),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "este es la pantalla número = $pageNumber"
        )
    }
}


@Composable
@Preview(showBackground = true)
fun ScreenShowListPreview(){
    EnsayoTheme{
        ScreenShowList(
            pageNumber = 1,
            colorBackground = MaterialTheme.colorScheme.onSurface
        )
    }
}