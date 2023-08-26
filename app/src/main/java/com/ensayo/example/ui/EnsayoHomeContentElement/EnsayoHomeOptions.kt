package com.ensayo.example.ui.EnsayoHomeContentElement

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensayo.example.data.local.StoreOptions
//import com.ensayo.example.ui.screens.ActivityStartScreenPruebas
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R

@Composable
fun EnsayoHomeOptions(
    modifier: Modifier = Modifier
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (i in StoreOptions.allValuesStoreOptions){
            EnsayoHomeOptionsCard(options = stringResource(id = i))
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
private fun EnsayoHomeOptionsCard(
    modifier: Modifier = Modifier,
    options: String,
) {
  Card(
      modifier = modifier
          .width(90.dp),
      colors = CardDefaults.cardColors(containerColor = Color.Transparent)
  ) {

      Column(
          modifier = modifier
              .fillMaxWidth(),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
      ) {
          Image(
              painter = painterResource(id = R.drawable.optionsss),
              contentDescription = stringResource(id = R.string.text_options),
              contentScale = ContentScale.FillBounds,
              modifier = Modifier
                  .size(40.dp)
          )
          Spacer(modifier = Modifier.height(5.dp))
          OptionsCard(options = options)
      }

  }
}

@Composable
fun OptionsCard(
    modifier: Modifier = Modifier,
    options: String
){
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = options,
                fontSize = 12.sp,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 7.dp, end = 7.dp, top = 3.dp, bottom = 3.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun EnsayoHomeOptionsCard(){
    EnsayoTheme {
        EnsayoHomeOptions()
    }
}