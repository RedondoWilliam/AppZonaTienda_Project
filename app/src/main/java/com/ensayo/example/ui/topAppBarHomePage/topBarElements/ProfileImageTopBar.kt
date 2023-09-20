package com.ensayo.example.ui.topAppBarHomePage.topBarElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R

@Composable
fun ProfileImageHome(
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(30.dp)
            .clip(CircleShape),
        painter = painterResource(id = R.drawable.foto_perfil),
        contentDescription = "description",
        contentScale = ContentScale.Crop
    )
}

@Composable
@Preview
fun ProfileImagePreview(){
    EnsayoTheme {
        Surface {
            ProfileImageHome()
        }
    }
}
