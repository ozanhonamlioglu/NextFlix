package tech.eightbits.home_ui.pages.home.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import tech.eightbits.core_network.MovieApi
import tech.eightbits.core_ui.utils.UiEvent
import tech.eightbits.home_ui.components.MagnifyLazyRow
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

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        onEvent(UiEvent.MovieFetch(MovieApi.Category_Popular, true))
    }

    MagnifyLazyRow(
        items = movies.value.data?.results ?: emptyList(),
        widthOfRow = context.resources.displayMetrics.widthPixels,
        boxMinSize = 100f,
        boxMaxSize = 180f,
        rowModifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        itemContainerModifier = Modifier.background(Color.Black)
    ) {
        Text(text = it.id.toString(), color = Color.Red)
    }

}