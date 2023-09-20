package com.ensayo.example.ui.ElementsHomePage

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ensayo.example.data.NavigationType
import com.ensayo.example.data.local.StoresBottom
import com.ensayo.example.ui.EnsayoApp.EnsayoUiState
import com.ensayo.example.ui.theme.EnsayoTheme
import com.example.ensayo.R
import com.example.pruebasejercicioensayo.horizontalPagerPage.HorizontalPagerPage


@SuppressLint("SuspiciousIndentation")
@Composable
fun EnsayoHomeScreen(
    ensayoUiState: EnsayoUiState,
    onTapPressed: (NavigationType) -> Unit,
    onSectionScreenTabPressed: (StoresBottom) -> Unit,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
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
        modifier = modifier,
        navController = navController
    )
}



@Composable
private fun EnsayoAppContent(
    ensayoUiState: EnsayoUiState,
    onTapPressed: (NavigationType) -> Unit,
    onSectionScreenTabPressed: (StoresBottom) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
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
            DinamicNavigationBottomBarHomePage(
                ensayoUiState = ensayoUiState,
                navController = navController
            )
        }
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
            .height(45.dp),
        containerColor = Color.Transparent
    ) {
        for (nav in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab ==nav.ensayoBoxType,
                onClick = { onTapPressed(nav.ensayoBoxType) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primaryContainer,
                    indicatorColor = MaterialTheme.colorScheme.background,

                ),
                icon = {
                   Column(
                       verticalArrangement = Arrangement.Center,
                       horizontalAlignment = Alignment.CenterHorizontally,
                       modifier = modifier.width(25.dp)
                   ) {
                      Box(
                          contentAlignment = Alignment.Center,
                          modifier = Modifier
                              .width(32.dp)
                              .height(32.dp)
                              .clip(CircleShape)
                              .background(
                                  if (currentTab == nav.ensayoBoxType)
                                      MaterialTheme.colorScheme.primaryContainer
                                  else MaterialTheme.colorScheme.background
                              )

                      ) {
                          Icon(
                              modifier = Modifier
                                  .width(22.dp)
                                  .height(22.dp),
                              imageVector = nav.icon,
                              contentDescription = nav.text,
                              tint = MaterialTheme.colorScheme.onBackground,
                          )
                      }
                       Text(
                           text = nav.text,
                           style = LocalTextStyle.current.merge(
                              TextStyle(
                                  fontFamily = FontFamily(
                                      Font(R.font.raleway_semi_bold)
                                  ),
                                  fontSize = 8.sp
                              )
                           ),


                       )
                   }
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