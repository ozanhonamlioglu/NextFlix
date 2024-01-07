package tech.eightbits.home_ui.pages.home

import androidx.compose.runtime.Composable
import tech.eightbits.core.utils.NavEvent
import tech.eightbits.core.utils.Routes
import tech.eightbits.core_ui.R

/**
 * Created by ozan on 7.01.2024
 */

@Composable
fun TopNavBar(
    event: (NavEvent) -> Unit
) {

}

val tabs = listOf(
    TopTabNav(
        Routes.HOME_TABS.MOVIES,
        R.string.movies
    ),
    TopTabNav(
        Routes.HOME_TABS.TV_SHOWS,
        R.string.tv_shows
    ),
    TopTabNav(
        Routes.HOME_TABS.MY_LIST,
        R.string.movies
    )
)

data class TopTabNav(
    val route: String,
    val title: Int
)