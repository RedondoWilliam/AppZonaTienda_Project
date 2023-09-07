package com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements

import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
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
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensayo.example.data.local.NearStoresValues
import com.ensayo.example.data.local.StoresBottom
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R

@Composable
fun ContentSectionNearStore(
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier
            .padding(start = 8.dp, top = 10.dp)
    ) {
        item {
            for (i in NearStoresValues.allValuesNearStores) {
                ContenSubSectionNearStore(
                    imageSubSectionPrincipal = i.imageSubsectionPrincipal,
                    stateOpenCloseStoreSubsection = i.stateOpenCloseStoreSubsection,
                    statePositionNearYouStoreSubsection = i.statePositionNearYouStoreSubsection,
                    nameStoreSubsection = i.nameStoreSubsection,
                    productsStoreSubsection = i.productsStoreSubsection,
                    likesScoreStoreSubsection =i.likesScoreStoreSubsection
                )
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }

}

@Composable
fun ContenSubSectionNearStore(
    modifier: Modifier = Modifier,
    @DrawableRes imageSubSectionPrincipal: Int,
    @StringRes stateOpenCloseStoreSubsection: Int,
    @StringRes statePositionNearYouStoreSubsection: Int,
    @StringRes nameStoreSubsection:Int,
    @StringRes  productsStoreSubsection: Int,
    @StringRes  likesScoreStoreSubsection: Int
){
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(3.dp))
    ) {
        Image(
            modifier = modifier
                .height(187.dp)
                .width(127.dp),
            painter = painterResource(id = imageSubSectionPrincipal),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        ContentSubSectionNearStoreInformation(
            stateOpenCloseStoreSubsection =stateOpenCloseStoreSubsection,
            statePositionNearYouStoreSubsection = statePositionNearYouStoreSubsection,
            nameStoreSubsection =  nameStoreSubsection,
            productsStoreSubsection = productsStoreSubsection,
            likesScoreStoreSubsection = likesScoreStoreSubsection,
            modifier = modifier.align(Alignment.BottomEnd),
        )
    }

}

@Composable
fun ContentSubSectionNearStoreInformation(
    modifier: Modifier = Modifier,
    @StringRes stateOpenCloseStoreSubsection: Int,
    @StringRes statePositionNearYouStoreSubsection: Int,
    @StringRes nameStoreSubsection:Int,
    @StringRes  productsStoreSubsection: Int,
    @StringRes  likesScoreStoreSubsection: Int
){
    Column(
//        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .clip(RoundedCornerShape(3.dp))
            .height(85.dp)
            .width(127.dp)
            .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.81f)),
    ) {
        NearStoreInformationNameAndDescriptionItem(
            nameStoreSubsection= nameStoreSubsection ,
            productsStoreSubsection = productsStoreSubsection,
            likesScoreStoreSubsection = likesScoreStoreSubsection
        )
        Spacer(modifier = modifier.height(4.dp))
        StateAndPositionInformation(
            stateOpenCloseStoreSubsection = stateOpenCloseStoreSubsection,
            statePositionNearYouStoreSubsection = statePositionNearYouStoreSubsection
        )
    }
}



@Composable
fun  NearStoreInformationNameAndDescriptionItem(
    modifier: Modifier = Modifier,
    @StringRes nameStoreSubsection:Int,
    @StringRes  productsStoreSubsection: Int,
    @StringRes  likesScoreStoreSubsection: Int
){
   Row() {
       Column(
       ) {
           Text(
               modifier = modifier
                   .width(91.dp),
               text = stringResource(id = nameStoreSubsection),
               maxLines = 1,
               style = LocalTextStyle.current.merge(
                   TextStyle(
                       lineHeight = 14.sp,
                       platformStyle = PlatformTextStyle(
                           includeFontPadding = false
                       ),
                       fontSize =10.sp,
                       lineHeightStyle = LineHeightStyle(
                           alignment = LineHeightStyle.Alignment.Bottom,
                           trim = LineHeightStyle.Trim.None
                       ),
                       fontFamily = FontFamily(
                           Font(R.font.raleway_extra_bold)
                       ),
                       color =  MaterialTheme.colorScheme.onPrimaryContainer
                   )
               )
           )
           Text(
               modifier = modifier
                   .width(91.dp),
               text = stringResource(id =  productsStoreSubsection),
               maxLines = 2,
               style = LocalTextStyle.current.merge(
                   TextStyle(
                       lineHeight = 9.sp,
                       platformStyle = PlatformTextStyle(
                           includeFontPadding = false
                       ),
                       fontSize =9.sp,
                       lineHeightStyle = LineHeightStyle(
                           alignment = LineHeightStyle.Alignment.Bottom,
                           trim = LineHeightStyle.Trim.None
                       ),
                       fontFamily = FontFamily(
                           Font(R.font.raleway_light)
                       ),
                       color =  MaterialTheme.colorScheme.onPrimaryContainer
                   )
               )
           )
       }
       Spacer(modifier = modifier.width(4.dp))
       NearStoreInformationScoreItem(
           likesScoreStoreSubsection = likesScoreStoreSubsection
       )
   }
}


@Composable
fun NearStoreInformationScoreItem(
    modifier: Modifier =  Modifier,
    @StringRes descriptionSubSectionScoreIcon:Int
    = R.string.description_heart_score_subsection_near_store,
    @StringRes  likesScoreStoreSubsection: Int
){
    Row {
        Text(
            text = stringResource(id =likesScoreStoreSubsection),
            style = LocalTextStyle.current.merge(
                TextStyle(
                    lineHeight = 10.sp,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    ),
                    fontSize =10.sp,
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Bottom,
                        trim = LineHeightStyle.Trim.None
                    ),
                    fontFamily = FontFamily(
                        Font(R.font.raleway_regular)
                    ),
                    color =  MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        )
        Icon(
            painter = painterResource(id = R.drawable.heart_icon),
            contentDescription = stringResource(id = descriptionSubSectionScoreIcon),
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = modifier
                .width(12.dp)
                .height(12.dp)
        )
    }
}

@Composable
fun StateAndPositionInformation(
    modifier: Modifier = Modifier,
    @StringRes stateOpenCloseStoreSubsection: Int,
    @StringRes statePositionNearYouStoreSubsection: Int
) {
   Row(
       modifier = modifier.height(45.dp)
   ) {
       Image(
           painter = painterResource(id = R.drawable.cartel_abierto),
           contentDescription = "",
           modifier = modifier
               .width(28.dp)
               .height(31.14.dp)
               .padding(top = 8.dp)
       )
       Column(
           modifier = modifier
               .fillMaxHeight()
               .width(100.dp),
           horizontalAlignment = Alignment.End
       ) {
           ScoreStartItem()
           StateAndPositionInformationItem(
               imageIcon = R.drawable.watch_statestore_item,
               stateOpenCloseAndPosition = stateOpenCloseStoreSubsection,
               fontStyle = R.font.raleway_regular,
               fonSizeItem = 8.sp
           )
           StateAndPositionInformationItem(
               imageIcon = R.drawable.icon_position_item_nearstore,
               stateOpenCloseAndPosition = statePositionNearYouStoreSubsection,
               fontStyle = R.font.raleway_regular,
               fonSizeItem = 9.sp
           )
//           Spacer(modifier = modifier.height(3.dp))

       }
   }
}

@Composable
fun StateAndPositionInformationItem(
    modifier: Modifier = Modifier,
    @DrawableRes imageIcon: Int,
    @StringRes stateOpenCloseAndPosition: Int,
    @FontRes fontStyle: Int,
    fonSizeItem: TextUnit
){
    Column {
        Row {
            Text(
                modifier = modifier
                    .width(90.dp)
                    .padding(end = 3.dp),
                text = stringResource(id = stateOpenCloseAndPosition),
                maxLines = 2,
                textAlign = TextAlign.End,
                style = LocalTextStyle.current.merge(
                    TextStyle(
                        lineHeight = fonSizeItem,
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        ),
                        fontSize =fonSizeItem,
                        lineHeightStyle = LineHeightStyle(
                            alignment = LineHeightStyle.Alignment.Bottom,
                            trim = LineHeightStyle.Trim.None
                        ),
                        fontFamily = FontFamily(
                            Font(fontStyle)
                        ),
                        color =  MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            )
            Icon(
                painter = painterResource(id = imageIcon),
                contentDescription ="",
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = modifier
                    .width(10.dp)
                    .height(10.dp)
            )
        }
    }
}


@Composable
fun ScoreStartItem(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier =modifier

    ) {
        for(i in 1..3){
            Icon(
                painter = painterResource(id = R.drawable.starnew),
                contentDescription ="",
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = modifier
                    .width(10.dp)
                    .height(10.dp)
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.star_mediumfill),
            contentDescription ="",
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = modifier
                .width(10.dp)
                .height(10.dp)

        )
        Icon(
            painter = painterResource(id = R.drawable.starfill),
            contentDescription ="",
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = modifier
                .width(10.dp)
                .height(10.dp)

        )
    }
}
@Composable
@Preview
fun CardStoresHomePreview(){
    EnsayoTheme {
        ContentSectionNearStore(
        )
    }
}


@Composable
@Preview(showBackground = true)
fun ContentSubSectionNearStorePreview(){
    EnsayoTheme {
        ContenSubSectionNearStore(
            imageSubSectionPrincipal = R.drawable.image_near_store_first,
            stateOpenCloseStoreSubsection = R.string.element_hours_store_nearstore_first,
            statePositionNearYouStoreSubsection =R.string.element_estimated_position_nearstore_first,
            nameStoreSubsection = R.string.element_nameitem_nearstore_first,
            productsStoreSubsection =R.string.element_descriptionresumestore_nearstore_first ,
            likesScoreStoreSubsection = R.string.element_likes_score_first
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ContentSubSectionNearStoreInformationPreview(){
    EnsayoTheme {
        ContentSubSectionNearStoreInformation(
            stateOpenCloseStoreSubsection = R.string.element_hours_store_nearstore_first,
            statePositionNearYouStoreSubsection =R.string.element_estimated_position_nearstore_first,
            nameStoreSubsection = R.string.element_nameitem_nearstore_first,
            productsStoreSubsection =R.string.element_descriptionresumestore_nearstore_first ,
            likesScoreStoreSubsection = R.string.element_likes_score_first
        )
    }
}

@Composable
@Preview(showBackground = true)
fun NearStoreInformationScoreItemPreview(){
    EnsayoTheme {
        NearStoreInformationScoreItem(
            likesScoreStoreSubsection = R.string.element_likes_score_first
        )
    }
}

@Composable
@Preview(showBackground = true)
fun NearStoreInformationNameAndDescriptionItemPreview(){
    EnsayoTheme {
        NearStoreInformationNameAndDescriptionItem(
            nameStoreSubsection = R.string.element_nameitem_nearstore_first,
            productsStoreSubsection = R.string.element_descriptionresumestore_nearstore_first,
            likesScoreStoreSubsection = R.string.element_likes_score_first
        )
    }
}

@Composable
@Preview(showBackground = true)
fun StateAndPositionInformationPreview(){
    EnsayoTheme {
        StateAndPositionInformation(
            stateOpenCloseStoreSubsection = R.string.element_hours_store_nearstore_first,
            statePositionNearYouStoreSubsection = R.string.element_estimated_position_nearstore_first
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ScoreStartItemPreview(){
    EnsayoTheme {
        ScoreStartItem()
    }
}