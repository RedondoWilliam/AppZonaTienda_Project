package com.ensayo.example.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import com.ensayo.example.ui.EnsayoHomeContentElement.EnsayoTheme
import com.ensayo.example.ui.theme.EnsayoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnsayoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    tonalElevation = 5.dp
                ) {
                    EnsayoApp()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EnsayoTheme {
        EnsayoApp()
    }
}