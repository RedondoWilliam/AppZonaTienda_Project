package com.ensayo.example.ui.ElementsHomePage.EnsayoHomeContentElements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.GpsFixed
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R
import com.example.ensayo.R.drawable.vector_icon_navigationbottonbar_home


@Composable
fun FloatingActionBottonScreen(
    modifier: Modifier = Modifier,

    ){
    val colorPrimaryElement: Color = MaterialTheme.colorScheme.surface
    val colorOnPrimaryElement: Color = MaterialTheme.colorScheme.onSurface
    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .offset((-10).dp, -10.dp)
            .clip(CircleShape),
        shape = MaterialTheme.shapes.large,
        contentColor = colorPrimaryElement
    ) {
        Icon(
            imageVector =ImageVector.Companion.vectorResource(
                R.drawable.vector_icon_floatingnavigationbotton_order
            ),
            contentDescription = null,
            tint = colorOnPrimaryElement
        )
    }
    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .offset((-10).dp, -80.dp)
            .clip(CircleShape),
        shape = MaterialTheme.shapes.large,
        contentColor = colorPrimaryElement
    ) {
        Icon(
            imageVector = ImageVector.Companion.vectorResource(
                R.drawable.vector_icon_floatingnavigationbotton_car
            ),
            contentDescription = null,
            tint = colorOnPrimaryElement
        )
    }
    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .offset((-10).dp, -150.dp)
            .clip(CircleShape),
        shape = MaterialTheme.shapes.large,
        contentColor = colorPrimaryElement
    ) {
        Icon(
            imageVector = ImageVector.Companion.vectorResource(
                R.drawable.vector_icon_floatingnavigationbotton_position
            ),
            contentDescription = null,
            tint = colorOnPrimaryElement
        )
    }
}


@Composable
@Preview(showBackground = true)
fun FloatingActionBottonScreenPreview(){
    EnsayoTheme(
        darkTheme = false
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(300.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingActionBottonScreen()
        }

    }
}
@Composable
@Preview(showBackground = true)
fun FloatingActionBottonScreenPreviewlightTheme(){
    EnsayoTheme(
        darkTheme = true
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(300.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingActionBottonScreen()
        }

    }
}