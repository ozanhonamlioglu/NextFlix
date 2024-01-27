package tech.eightbits.home_ui.pages


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tech.eightbits.core.utils.Routes
import tech.eightbits.home_ui.pages.home.HomeScreen


/**
 * Created by ozan on 7.01.2024
 */

@Composable
fun MainScreen() {
    val bottomNavHostController = rememberNavController()

    Scaffold(
        bottomBar = {}
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            NavHost(bottomNavHostController, startDestination = Routes.MAIN_TABS.HOME) {
                composable(Routes.MAIN_TABS.HOME) {
                    HomeScreen()
                }
                composable(Routes.MAIN_TABS.PROFILE) {
                    // HomeScreen()
                }
                composable(Routes.MAIN_TABS.SEARCH) {
                    // HomeScreen()
                }
            }
        }
    }
}