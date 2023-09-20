package com.ensayo.example.ui.VisitPageElements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ensayo.example.ui.theme.EnsayoTheme

@Composable
fun VisitPageElements(
    modifier: Modifier = Modifier,
    thisCurrentPage: String
){
    Box(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = thisCurrentPage
        )
    }
}

@Composable
@Preview(showBackground = true)
fun VisitPageElementsPreview(){
    EnsayoTheme {
        VisitPageElements(thisCurrentPage = "Esta es una pantalla" )
    }
}