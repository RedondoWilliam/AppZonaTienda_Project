package com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensayo.example.data.local.StoresBottom
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R

@Composable
fun HomeStoreOptions(
    modifier: Modifier = Modifier
){
    LazyRow(
        modifier = modifier.padding(top = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(StoresBottom.allValuesStoresBotton){ item ->
            Spacer(modifier = Modifier.width(5.dp))
            for (i in StoresBottom.allValuesStoresBotton){
                ContentPrincipalSubSection(
                    imageSubSectionPrincipal = i.imageSubSectionPrincipal,
                    titleSubSectionPrincipal = i.titleSubSectionPrincipal,
                    subTitleSubSectionPrincipal =i.subTitleSubSectionPrincipal
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }

    }
}


@Composable
private fun ContentPrincipalSubSection(
    modifier: Modifier = Modifier,
    @DrawableRes imageSubSectionPrincipal: Int,
    @StringRes titleSubSectionPrincipal: Int,
    @StringRes subTitleSubSectionPrincipal: Int
) {
    Column {
        Image(
            modifier = modifier
                .clip(RoundedCornerShape(3.dp))
                .height(62.dp)
                .width(137.dp),
            painter = painterResource(id = imageSubSectionPrincipal),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        SelectionContainer {
            Text(
                text = stringResource(id = titleSubSectionPrincipal),
                style = LocalTextStyle.current.merge(
                    TextStyle(
                        lineHeight = 14.sp,
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        ),
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        lineHeightStyle = LineHeightStyle(
                            alignment = LineHeightStyle.Alignment.Bottom,
                            trim = LineHeightStyle.Trim.None
                        ),
                        fontFamily = FontFamily(
                            Font(R.font.raleway_medium)
                        ),
                    )
                )
            )
        }
        SelectionContainer {
            Text(
                modifier = modifier,
                text = stringResource(id = subTitleSubSectionPrincipal),
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontFamily = FontFamily(
                    Font(R.font.raleway_extra_light)
                ),
                style = LocalTextStyle.current.merge(
                    TextStyle(
                        lineHeight = 14.sp,
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        ),
                        lineHeightStyle = LineHeightStyle(
                            alignment = LineHeightStyle.Alignment.Top,
                            trim = LineHeightStyle.Trim.None
                        )
                    )
                )
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ContentPrincipalSubSectionPreview(){
    EnsayoTheme {
        ContentPrincipalSubSection(
            imageSubSectionPrincipal = R.drawable.bares,
            titleSubSectionPrincipal = R.string.element_bares,
            subTitleSubSectionPrincipal = R.string.element_entretenimiento
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeStoreOptionsPreview(){
    EnsayoTheme {
        HomeStoreOptions()
    }
}