package com.ensayo.example.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.DoorFront
import androidx.compose.material.icons.filled.PostAdd
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.ensayo.example.data.NavigationType
import com.ensayo.example.data.local.StoresBottom
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
          icon = Icons.Default.Store,
          text = stringResource(id = R.string.element_inicio)
      ),
      NavigationItemContent(
          ensayoBoxType = NavigationType.VISITA,
          icon = Icons.Default.DoorFront,
          text = stringResource(id = R.string.element_visita)
      ),
      NavigationItemContent(
          ensayoBoxType = NavigationType.CHAD,
          icon = Icons.Default.Chat,
          text = stringResource(id = R.string.element_chad)
      ),
      NavigationItemContent(
          ensayoBoxType = NavigationType.POST,
          icon = Icons.Default.PostAdd,
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
    Box (modifier = modifier
        .fillMaxSize()){
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
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ){
           PrincipalScreenTopAppBar(
               modifier.weight(1f)
           )
           EnsayoBottomNavigationBar(
               currentTab = ensayoUiState.currentEnsayoBoxType,
               onTapPressed = onTapPressed,
               navigationItemContentList = navigationItemContentList,
               modifier = modifier.fillMaxWidth()
           )
        }
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
    NavigationBar(modifier = modifier) {
        for (nav in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab ==nav.ensayoBoxType,
                onClick = { onTapPressed(nav.ensayoBoxType) },
                icon = {
                    Icon(
                        imageVector = nav.icon,
                        contentDescription = nav.text)
                })
        }
    }
}




private data class NavigationItemContent(
    val ensayoBoxType: NavigationType,
    val icon: ImageVector,
    val text: String
    )