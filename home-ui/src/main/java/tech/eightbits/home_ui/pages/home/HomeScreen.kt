package tech.eightbits.home_ui.pages.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tech.eightbits.core.utils.NavEvent
import tech.eightbits.core.utils.Routes

/**
 * Created by ozan on 7.01.2024
 */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {

    val topNavHostController = rememberNavController()

    Scaffold(
        topBar = {
            TopNavBar(event = {})
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            NavHost(topNavHostController, startDestination = Routes.HOME_TABS.MOVIES) {
                composable(Routes.HOME_TABS.MOVIES) {

                }
            }
        }
    }

}