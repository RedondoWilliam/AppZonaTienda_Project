package com.ensayo.example.ui.ElementsHomePage

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.DoorFront
import androidx.compose.material.icons.filled.PostAdd
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.ensayo.example.data.NavigationType
import com.ensayo.example.data.local.StoresBottom
import com.ensayo.example.ui.EnsayoApp.EnsayoUiState
import com.example.ensayo.R
import com.example.pruebasejercicioensayo.PruebaTopAppBar.PrincipalScreenTopAppBar


@SuppressLint("SuspiciousIndentation")
@Composable
fun EnsayoHomeScreen(
    ensayoUiState: EnsayoUiState,
    onTapPressed: (NavigationType) -> Unit,
    onSectionScreenTabPressed: (StoresBottom) -> Unit,
    modifier: Modifier = Modifier
) {
  val navigationItemContentList= listOf(
      NavigationItemContent(
          ensayoBoxType = NavigationType.INICIO,
          icon =  ImageVector.Companion.vectorResource(
              R.drawable.vector_icon_navigationbottonbar_home
          ),
          text = stringResource(id = R.string.element_inicio)
      ),
      NavigationItemContent(
          ensayoBoxType = NavigationType.VISITA,
          icon = ImageVector.Companion.vectorResource(
              R.drawable.vector_icon_navigationbottonbar_door
          ),
          text = stringResource(id = R.string.element_visita)
      ),
      NavigationItemContent(
          ensayoBoxType = NavigationType.CHAD,
          icon = ImageVector.Companion.vectorResource(
              R.drawable.vector_icon_navigationbottonbar_chat
          ),
          text = stringResource(id = R.string.element_chad)
      ),
      NavigationItemContent(
          ensayoBoxType = NavigationType.POST,
          icon = ImageVector.Companion.vectorResource(
              R.drawable.vector_icon_navigationbottonbar_post
          ),
          text = stringResource(id = R.string.element_post)
      ),
      NavigationItemContent(
          ensayoBoxType = NavigationType.MENU,
          icon = ImageVector.Companion.vectorResource(
              R.drawable.vector_icon_navigationbottonbar_menu
          ),
          text = stringResource(id = R.string.element_post)
      )
  )

    EnsayoAppContent(
        ensayoUiState = ensayoUiState,
        onTapPressed = onTapPressed,
        onSectionScreenTabPressed = onSectionScreenTabPressed,
        navigationItemContentList = navigationItemContentList,
        modifier = modifier
    )
}



@Composable
private fun EnsayoAppContent(
    ensayoUiState: EnsayoUiState,
    onTapPressed: (NavigationType) -> Unit,
    onSectionScreenTabPressed: (StoresBottom) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
){
    val navigationRailEnsayoContentDescription =
        stringResource(id = R.string.navigation_rail_ensayo)
    EnsayoNavigationRail(
        currentTab = ensayoUiState.currentEnsayoBoxType,
        onTapPressed = onTapPressed,
        navigationItemContentList = navigationItemContentList,
        modifier = Modifier.testTag(navigationRailEnsayoContentDescription)
    )
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .weight(1f)
        ){
            PrincipalScreenTopAppBar(
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp)
        )
        EnsayoBottomNavigationBar(
            currentTab = ensayoUiState.currentEnsayoBoxType,
            onTapPressed = onTapPressed,
            navigationItemContentList = navigationItemContentList,
            modifier = modifier
                .fillMaxWidth()
        )
    }
}





@Composable
private fun EnsayoNavigationRail(
    currentTab: NavigationType,
    onTapPressed: (NavigationType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
){
    NavigationRail(modifier = modifier) {
        for (navitem in navigationItemContentList){
            NavigationRailItem(
                selected = currentTab == navitem.ensayoBoxType,
                onClick = { onTapPressed(navitem.ensayoBoxType) },
                icon = {
                    Icon(
                        imageVector = navitem.icon,
                        contentDescription = navitem.text
                    )
                }
            )
        }
    }
}


@Composable
private fun EnsayoBottomNavigationBar(
    currentTab: NavigationType,
    onTapPressed: (NavigationType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
){
    NavigationBar(
        modifier = modifier
            .height(60.dp),
        containerColor = Color.Transparent
    ) {
        for (nav in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab ==nav.ensayoBoxType,
                onClick = { onTapPressed(nav.ensayoBoxType) },
                icon = {
                    Icon(
                        imageVector = nav.icon,
                        contentDescription = nav.text,
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                },

            )
        }
    }
}




private data class NavigationItemContent(
    val ensayoBoxType: NavigationType,
    val icon: ImageVector,
    val text: String
    )