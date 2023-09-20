package com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements

//import android.graphics.Color
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ensayo.example.data.local.StoreOptions
import com.ensayo.example.ui.commonElements.textCommonHomePage
import com.ensayo.example.ui.horizontalPagerPage.ViewModelHorizontalPagerPage
import com.ensayo.example.ui.theme.EnsayoTheme
//import com.ensayo.example.ui.screens.ActivityStartScreenPruebas
import com.example.ensayo.R

@Composable
fun EnsayoHomeOptions(
    modifier: Modifier = Modifier
){
    val viewModelHorizontalPager: ViewModelHorizontalPagerPage = viewModel()
    val horizontalPagerUiState = viewModelHorizontalPager.uiState.collectAsState().value
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically

    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(start = 8.dp, top = 6.dp, bottom = 6.dp)
                .weight(0.85f)
            ,
            verticalAlignment = Alignment.CenterVertically

        ) {
            item {
                for (i in StoreOptions.allValuesStoreOptions){
                    SubSectionsPageHome(
                        nameSubSection = i.nameSubSection,
                        imageSubSection = i.imageSubSection,
                        descriptionSubSection = i.descriptionSubSection,
                        backgroundItem =
                        if (horizontalPagerUiState.stateHorizontalPager.name ==
                            stringResource(id = i.idItemSubsection))
                            Color.Black
                            else
                                MaterialTheme.colorScheme.background,
                        colorItem =
                        if (horizontalPagerUiState.stateHorizontalPager.name ==
                            stringResource(id = i.idItemSubsection))
                            Color.White
                        else
                            MaterialTheme.colorScheme.onBackground,
                        colorBorderItem =
                        if (horizontalPagerUiState.stateHorizontalPager.name ==
                            stringResource(id = i.idItemSubsection))
                            MaterialTheme.colorScheme.primaryContainer
                        else
                            MaterialTheme.colorScheme.background,
                        witdhBorderItem =
                        if (horizontalPagerUiState.stateHorizontalPager.name ==
                            stringResource(id = i.idItemSubsection))
                            3.dp
                        else
                            0.dp,

                    )
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }

        }
        Icon(
            modifier = modifier
                .width(20.dp)
                .height(20.dp),
            imageVector = ImageVector.Companion.vectorResource(
                R.drawable.arrow_next
            ),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}


@Composable
 fun SubSectionsPageHome(
    modifier: Modifier = Modifier,
    @StringRes nameSubSection: Int,
    @DrawableRes imageSubSection: Int,
    @StringRes descriptionSubSection: Int,
    backgroundItem: Color = Color.White,
    colorItem: Color =  Color.Black,
    colorBorderItem: Color = Color.Black,
    witdhBorderItem: Dp = 0.0.dp,
    ) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .width(60.dp)
                .height(60.dp)
                .clip(CircleShape)
                .border(witdhBorderItem, colorBorderItem, shape = CircleShape)
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 8.dp,
                        shape = CircleShape
                    )
                    .clip(CircleShape)
                    .width(45.dp)
                    .height(45.dp)
                    .border(
                        0.5.dp,
                        MaterialTheme.colorScheme.onBackground,
                        shape = CircleShape)
                    .background(backgroundItem),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    painter = painterResource(id = imageSubSection),
                    contentDescription = stringResource(id = descriptionSubSection),
                    tint = colorItem,
                    modifier = modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
        }

        OptionsCard(nameSubSection = nameSubSection)
    }

}

@Composable
fun OptionsCard(
    modifier: Modifier = Modifier,
    @StringRes nameSubSection: Int
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {

        textCommonHomePage(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 7.dp, end = 7.dp, top = 3.dp, bottom = 3.dp),
            stringResTextEntry = nameSubSection,
            maxLinesResParameter = 1 ,
            lineHeightParameter = 10.sp,
            fontSizeStyleParameter = 10.sp ,
            fontFamilyStyleParameter = FontFamily(Font(R.font.raleway_medium)),
            colorStyleParameter = MaterialTheme.colorScheme.onBackground
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