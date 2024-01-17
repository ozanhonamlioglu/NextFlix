package tech.eightbits.home_ui.pages.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.eightbits.core.utils.NavEvent
import tech.eightbits.core.utils.Routes
import tech.eightbits.core_ui.R
import tech.eightbits.core_ui.theme.NextflixTheme

/**
 * Created by ozan on 7.01.2024
 */

@Composable
fun CategoryNavBar(
    event: (NavEvent) -> Unit,
) {

    val currentTab = rememberSaveable() {
        mutableStateOf(Routes.HOME_TABS.MOVIES)
    }

    fun changeTab(route: String) {
        currentTab.value = route
        event(NavEvent.Navigate(route))
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            tabs.map {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = MaterialTheme.colorScheme.onBackground
                    ),
                    onClick = { changeTab(it.route) },
                ) {
                    Text(
                        text = stringResource(id = it.title),
                        color = if (currentTab.value == it.route)
                            MaterialTheme.colorScheme.tertiary
                        else
                            MaterialTheme.colorScheme.onTertiaryContainer,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        fontWeight = FontWeight(600)
                    )
                }
            }
        }
    }

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
        R.string.my_list
    )
)

data class TopTabNav(
    val route: String,
    val title: Int
)

@Preview(
    name = "Light",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Dark",
    locale = "tr",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
fun PreviewCategoryNavBar() {
    NextflixTheme {
        CategoryNavBar(event = {})
    }
}