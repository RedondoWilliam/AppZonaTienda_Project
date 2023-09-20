package com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
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
import com.ensayo.example.ui.commonElements.textCommonHomePage
import com.ensayo.example.ui.theme.EnsayoTheme
import com.ensayo.example.ui.theme.typography
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
            .height(260.dp)
            .width(200.dp),
        contentAlignment = Alignment.TopEnd
    ) {

        Image(
            painter = painterResource(id = imageSubSectionPrincipal),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxSize(),
        )
        LikesReactions(
            modifier.padding(top = 7.dp, end = 7.dp)
        )
        ContentSubSectionNearStoreInformation(
            stateOpenCloseStoreSubsection =stateOpenCloseStoreSubsection,
            statePositionNearYouStoreSubsection = statePositionNearYouStoreSubsection,
            nameStoreSubsection =  nameStoreSubsection,
            productsStoreSubsection = productsStoreSubsection,
            likesScoreStoreSubsection = likesScoreStoreSubsection,
            modifier = modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 7.dp, end = 7.dp),
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
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    bottomStart = 0.dp, topEnd = 10.dp, topStart = 10.dp, bottomEnd = 10.dp
                )
            )
            .height(68.dp)
            .width(188.dp)
            .background(
                colorResource(
                    id = R.color.color_content_information_nears_stores
                ).copy(alpha = 0.81f),
            ),
    ) {
        NearStoreInformationNameAndDescriptionItem(
            nameStoreSubsection= nameStoreSubsection ,
            productsStoreSubsection = productsStoreSubsection,
            likesScoreStoreSubsection = likesScoreStoreSubsection,
        )
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
    Column(
        modifier = modifier.padding(start = 10.dp)
    ) {
        textCommonHomePage(
            modifier =  modifier.width(188.dp),
            stringResTextEntry = nameStoreSubsection,
            maxLinesResParameter = 1,
            lineHeightParameter = 14.sp,
            lineHeightStyle = LineHeightStyle.Alignment.Bottom,
            fontSizeStyleParameter = typography.bodySmall.fontSize,
            fontFamilyStyleParameter = typography.bodyLarge.fontFamily,
            colorStyleParameter = MaterialTheme.colorScheme.onPrimaryContainer
        )
        textCommonHomePage(
            modifier = modifier.width(188.dp),
            stringResTextEntry = productsStoreSubsection,
            maxLinesResParameter = 1,
            lineHeightParameter = 9.sp ,
            fontSizeStyleParameter = 9.sp,
            fontFamilyStyleParameter =  FontFamily(Font(R.font.raleway_semi_bold)),
            colorStyleParameter = MaterialTheme.colorScheme.onPrimaryContainer
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
    Row(
    ) {
        textCommonHomePage(
            stringResTextEntry = likesScoreStoreSubsection,
            maxLinesResParameter = 1,
            lineHeightParameter = 10.sp,
            fontSizeStyleParameter = 10.sp,
            fontFamilyStyleParameter = FontFamily(Font(R.font.raleway_regular)),
            colorStyleParameter = MaterialTheme.colorScheme.onPrimaryContainer
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
       modifier = modifier
           .padding(start = 10.dp)
           .width(188.dp)
           .height(45.dp),
       verticalAlignment = Alignment.CenterVertically,
       horizontalArrangement = Arrangement.SpaceBetween

   ) {
       Column(
           modifier = modifier
               .fillMaxHeight()
               .width(115.dp)
               .padding(bottom = 5.dp),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Bottom
       ) {

           StateAndPositionInformationItem(
               imageIcon = R.drawable.icon_position_item_nearstore,
               stateOpenCloseAndPosition = statePositionNearYouStoreSubsection,
               fontStyle = R.font.raleway_regular,
               fonSizeItem = 9.sp
           )
           Spacer(modifier = modifier.height(3.dp))
           StateAndPositionInformationItem(
               imageIcon = R.drawable.watch_statestore_item_two,
               stateOpenCloseAndPosition = stateOpenCloseStoreSubsection,
               fontStyle = R.font.raleway_regular,
               fonSizeItem = 8.sp
           )

       }
       Column(
           modifier = modifier
               .padding(top = 2.dp, end = 5.dp)
               .height(45.dp),
           horizontalAlignment = Alignment.End
       ) {
           ScoreStartItem()
           Spacer(modifier = modifier.height(4.dp))
           StateOpenCloseRealTimeNearStore()
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
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = imageIcon),
            contentDescription ="",
            tint = colorResource(id = R.color.color_icons_items_open_and_state),
            modifier = modifier
                .width(8.dp)
                .height(8.dp)
        )
        Spacer(modifier = modifier.width(4.dp))
        textCommonHomePage(
            modifier = modifier
                .width(100.dp)
                .padding(end = 3.dp),
            stringResTextEntry = stateOpenCloseAndPosition,
            maxLinesResParameter = 2,
            lineHeightParameter = 9.sp,
            fontSizeStyleParameter = 9.sp ,
            fontFamilyStyleParameter = FontFamily(Font(R.font.raleway_semi_bold)),
            colorStyleParameter = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}


@Composable
fun ScoreStartItem(
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.starss),
        contentDescription ="",
        tint = colorResource(id = R.color.color_stars),
        modifier = modifier
            .width(63.dp)
            .height(13.dp)
    )
}

@Composable
fun LikesReactions(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .width(24.dp)
            .height(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.heart_icon),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier
                .width(16.dp)
                .height(16.dp)

        )
    }
}


@Composable
fun StateOpenCloseRealTimeNearStore(
    modifier: Modifier = Modifier
){
   textCommonHomePage(
       stringResTextEntry = R.string.state_open_and_close_open,
       maxLinesResParameter = 1,
       lineHeightParameter = 9.sp,
       fontSizeStyleParameter = 9.sp,
       fontFamilyStyleParameter = FontFamily(Font( R.font.raleway_medium)),
       colorStyleParameter = MaterialTheme.colorScheme.onPrimaryContainer,
       modifier = modifier
           .clip(CircleShape)
           .background(colorResource(id = R.color.state_open_close_real_time_near_store))
           .padding(start = 10.dp, end = 10.dp, top = 2.dp, bottom = 2.dp)

   )
}



@Composable
@Preview(showBackground = true)
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

@Composable
@Preview(showBackground = true)
fun LikesReactionsPreview(){
    EnsayoTheme {
        LikesReactions()
    }
}

@Composable
@Preview(showBackground = true)
fun StateOpenCloseRealTimeNearStorePreview(){
    EnsayoTheme {
        StateOpenCloseRealTimeNearStore()
    }
}