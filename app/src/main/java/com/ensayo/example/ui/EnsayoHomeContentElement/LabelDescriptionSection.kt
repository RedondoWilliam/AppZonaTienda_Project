package com.ensayo.example.ui.EnsayoHomeContentElement

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensayo.example.ui.theme.EnsayoTheme


@Composable
fun DescriptionSectionCard(
    modifier: Modifier = Modifier,
    options: String,
){
    Row(
        modifier = modifier.padding(8.dp)
    ) {
        OptionsCardSections(options = options)
    }
}


@Composable
fun OptionsCardSections(
    modifier: Modifier = Modifier,
    options: String,
    maxLines: Int = 1
){
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier =
            if (maxLines == 7) modifier.width(140.dp)
            else if (maxLines == 3) modifier.fillMaxWidth()
            else modifier
        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = options,
                fontSize = 14.sp,
                modifier = modifier
                    .padding(start = 10.dp, end = 10.dp, top = 3.dp, bottom = 3.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@Preview
private fun DescriptionSectionCardPreview(){
    EnsayoTheme {
        DescriptionSectionCard(options = "tiendas cerca")
    }
}