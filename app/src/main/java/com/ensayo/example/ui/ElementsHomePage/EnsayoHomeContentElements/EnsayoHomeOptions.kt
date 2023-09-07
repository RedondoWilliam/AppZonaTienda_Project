package com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensayo.example.data.local.StoreOptions
import com.ensayo.example.ui.theme.EnsayoTheme
//import com.ensayo.example.ui.screens.ActivityStartScreenPruebas
import com.example.ensayo.R

@Composable
fun EnsayoHomeOptions(
    modifier: Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(start = 8.dp, top = 6.dp, bottom = 6.dp),

    ) {
        for (i in StoreOptions.allValuesStoreOptions){
           SubSectionsPageHome(
               nameSubSection = i.nameSubSection,
               imageSubSection = i.imageSubSection,
               descriptionSubSection = i.descriptionSubSection
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
private fun SubSectionsPageHome(
    modifier: Modifier = Modifier,
    @StringRes nameSubSection: Int,
    @DrawableRes imageSubSection: Int,
    @StringRes descriptionSubSection: Int
) {

    Column(
        modifier = modifier,
//            .width(90.dp),
//            .padding(top = 9.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            painter = painterResource(id = imageSubSection),
            contentDescription = stringResource(id = descriptionSubSection),
            tint = MaterialTheme.colorScheme.onBackground,
            modifier = modifier
                .width(25.dp)
                .height(25.dp)
        )
//        OptionsCard(nameSubSection = nameSubSection)

    }
}

@Composable
fun OptionsCard(
    modifier: Modifier = Modifier,
    @StringRes nameSubSection: Int
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(shape = MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = stringResource(id = nameSubSection),
            fontSize = 10.sp,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 7.dp, end = 7.dp, top = 3.dp, bottom = 3.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            fontFamily = FontFamily(
                Font(R.font.raleway_medium)
            ),
            color = MaterialTheme.colorScheme.onPrimary

            )
    }
}

@Composable
@Preview(showBackground = true)
fun EnsayoHomeOptionsCard(){
    EnsayoTheme {
        EnsayoHomeOptions()
    }
}