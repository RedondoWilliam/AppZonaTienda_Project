package com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R

@Composable
fun HomePromotionsStore(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int
){
    Column(
        modifier = modifier
            .padding(start = 8.dp, top = 8.dp, end = 5.dp)
            .fillMaxWidth()
            .height(270.dp)
            .clip(RoundedCornerShape(3.dp))
    ) {
        Image(
            modifier = modifier.fillMaxSize(),
            painter = painterResource(id = image),
            contentDescription ="",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomePromotionsStorePreview(){
    EnsayoTheme {
        HomePromotionsStore(image = R.drawable.promociones)
    }
}