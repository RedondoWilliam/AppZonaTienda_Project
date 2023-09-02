package com.ensayo.example.ui.ElementsTopAppBarHomePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ensayo.R

@Composable
fun ProfileImage(
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(30.dp)
            .clip(CircleShape)
            .fillMaxSize(),
        painter = painterResource(id = R.drawable.foto_perfil),
        contentDescription = "description",
        contentScale = ContentScale.Crop
    )
}
