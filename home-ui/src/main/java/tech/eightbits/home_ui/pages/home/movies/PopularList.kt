package tech.eightbits.home_ui.pages.home.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import tech.eightbits.core_network.MovieApi
import tech.eightbits.core_ui.utils.UiEvent
import tech.eightbits.home_ui.data.viewmodels.movies.MoviesViewModel

/**
 * Created by ozan on 16.01.2024
 */

@Composable
fun PopularList(
    moviesViewModel: MoviesViewModel,
    onEvent: (UiEvent) -> Unit
) {
    val movies = moviesViewModel.popularList.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        onEvent(UiEvent.MovieFetch(MovieApi.Category_Popular, true))
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(movies.value) { movieItem ->
            Box(
                modifier = Modifier
                    .width(90.dp)
                    .height(100.dp)
                    .background(Color.Black)
            )
        }
    }


}