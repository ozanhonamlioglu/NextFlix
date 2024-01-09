package tech.eightbits.home_ui.pages.home

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tech.eightbits.core.utils.Routes
import tech.eightbits.core_ui.extensions.navigate
import tech.eightbits.core_ui.theme.NextflixTheme
import tech.eightbits.home_ui.pages.home.movies.MoviesScreen
import tech.eightbits.home_ui.pages.home.mylist.MyListScreen
import tech.eightbits.home_ui.pages.home.tvshows.TvShowsScreen

/**
 * Created by ozan on 7.01.2024
 */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {

    val topNavHostController = rememberNavController()

    Scaffold(
        topBar = {
            CategoryNavBar(
                event = {
                    topNavHostController.navigate(it)
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            NavHost(topNavHostController, startDestination = Routes.HOME_TABS.MOVIES) {
                composable(Routes.HOME_TABS.MOVIES) {
                    MoviesScreen()
                }
                composable(Routes.HOME_TABS.TV_SHOWS) {
                    TvShowsScreen()
                }
                composable(Routes.HOME_TABS.MY_LIST) {
                    MyListScreen()
                }
            }
        }
    }

}

@Preview(
    locale = "tr",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewHomeScreen() {
    NextflixTheme {
        HomeScreen()
    }
}