package com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensayo.example.ui.commonElements.textCommonHomePage
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R


@Composable
fun DescriptionSectionCard(
    modifier: Modifier = Modifier,
    @StringRes options: Int,
){
    OptionsCardSections(options = options)
}


@Composable
fun OptionsCardSections(
    modifier: Modifier = Modifier,
    @StringRes options: Int,
    maxLines: Int = 1
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .padding(start = 10.dp, end = 10.dp),
    ) {

        textCommonHomePage(
            stringResTextEntry = options,
            maxLinesResParameter = 1,
            lineHeightParameter = MaterialTheme.typography.bodyLarge.fontSize,
            fontSizeStyleParameter = MaterialTheme.typography.bodyLarge.fontSize,
            fontFamilyStyleParameter =  FontFamily(Font(R.font.raleway_bold)),
            colorStyleParameter = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
@Preview
private fun DescriptionSectionCardPreview(){
    EnsayoTheme {
        DescriptionSectionCard(options = R.string.principal)
    }
}