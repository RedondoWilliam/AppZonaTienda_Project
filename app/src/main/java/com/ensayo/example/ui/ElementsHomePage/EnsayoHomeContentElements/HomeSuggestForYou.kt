package com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements

import android.content.ClipData.Item
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensayo.example.data.local.NearStoresSuggestForYOu
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R


@Composable
fun HomeSuggestForYou(
    modifier: Modifier = Modifier
){

    LazyRow(
        modifier = modifier
            .padding(start = 8.dp, top = 10.dp)
    ){
        item{
            for(i in NearStoresSuggestForYOu.allValuesNearStores){
                ContentPrincipalSubSection(
                    imageSubSectionPrincipal = i.imageSubsectionPrincipal ,
                    titleSubSectionPrincipal =  i.nameStoreSubsection,
                    subTitleSubSectionPrincipal = i.nearStoresForYou
                )
//                HomeSuggestForYouElements(
//                    imageSection = i.imageSubsectionPrincipal,
//                    titleSection = i.nameStoreSubsection,
//                    nearStores =i.nearStoresForYou
//                )
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}

@Composable
fun HomeSuggestForYouElements(
    modifier: Modifier = Modifier,
    @DrawableRes imageSection: Int,
    @StringRes titleSection: Int,
    @StringRes nearStores: Int
){
    Box(
        modifier = modifier
            .width(156.dp)
            .height(59.dp)
            .clip(RoundedCornerShape(3.dp)),
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            painter = painterResource(id = imageSection),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = modifier
                .width(99.dp)
                .height(59.dp)
                .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.81f))
        ) {
            Text(
                text = stringResource(id = titleSection)
            )
            Text(text = stringResource(id = nearStores))
        }
    }
}


@Composable
@Preview(showBackground = true)
fun HomeSuggestForYouPreview(){
    EnsayoTheme {
        HomeSuggestForYou()
    }
}
@Composable
@Preview(showBackground = true)
fun  HomeSuggestForYouElementsPreview(){
    EnsayoTheme {
        HomeSuggestForYouElements(
            imageSection = R.drawable.tintorerias,
            titleSection = R.string.tintorerias,
            nearStores = R.string.sitios_cerca
        )
    }
}