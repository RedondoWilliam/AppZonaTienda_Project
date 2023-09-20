package com.ensayo.example.ui.EnsayoApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ensayo.example.ui.ElementsHomePage.navigationPanelControl.started
import com.ensayo.example.ui.navigationElemenentsSubsections.NavigationElementsSubsections
import com.ensayo.example.ui.pageSearchHome.RecientsSearchBarPage
//import com.ensayo.example.ui.EnsayoHomeContentElement.EnsayoTheme
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.barradenavegacion.data.SearchWidgetState
import com.example.barradenavegacion.ui.theme.ViewModelTopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            EnsayoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    tonalElevation = 5.dp
                ) {
                    NavigationElementsSubsections()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EnsayoTheme {
        Surface(
            tonalElevation = 5.dp
        ){
        EnsayoApp()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreviewSurface() {
    EnsayoTheme {
        EnsayoApp()
    }
}