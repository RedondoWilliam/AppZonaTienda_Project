package com.ensayo.example.ui.EnsayoHomeContentElement

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R


@Composable
fun EnsayoHomeTopBar(
    onBottonOptionsPressed: () -> Unit = {},
    modifier: Modifier = Modifier,
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(8.dp)
    ) {
        EnsayoBottonOptions(
            onBottonOptionsPressed = onBottonOptionsPressed
        )
        SearchBar()
        EnsayoProfileImage(
            modifier = Modifier
                .size(48.dp),
            drawableResource = R.drawable.profileimage,
            description = stringResource(id = R.string.image_profile)
        )
    }
}

@Composable
fun EnsayoBottonOptions(
    onBottonOptionsPressed: () -> Unit ={},
    modifier: Modifier = Modifier,
    color : Color = MaterialTheme.colorScheme.primary
) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = {
            expanded = !expanded
        }) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = stringResource(id = R.string.descriptioniconoptionshomepage)
        )
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded =false }
    ) {
        DropdownMenuItem(
            text = { Text(text = "primer item") },
            onClick = { expanded = false}
        )
        DropdownMenuItem(
            text = { Text(text = "segundo item") },
            onClick = { expanded = false}
        )
        DropdownMenuItem(
            text = { Text(text = "tercer item") },
            onClick = { expanded = false}
        )
    }
}



@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    userGuess: String = "",
    onUserGuessChanged: (String) -> Unit = {},
    onKeyboardDone: () -> Unit = {}

){
    OutlinedTextField(
        value = userGuess,
        singleLine = true,
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.fillMaxWidth(0.8f),
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = MaterialTheme.colorScheme.onSurface,
        ),
        onValueChange = onUserGuessChanged,
        label = {
            Text(stringResource(id = R.string.buscar))
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {onKeyboardDone() }
        )
    )
}


@Composable
fun EnsayoProfileImage(
    @DrawableRes drawableResource: Int,
    description: String,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier){
        Image(
            modifier = Modifier.clip(CircleShape),
            painter = painterResource(drawableResource ),
            contentDescription = description,
        )
    }
}




@Composable
@Preview(showBackground = true)
fun SearchBarPreview() {
    EnsayoTheme {
        EnsayoHomeTopBar()
    }
}