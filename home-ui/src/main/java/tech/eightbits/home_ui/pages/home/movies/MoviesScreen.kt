package tech.eightbits.home_ui.pages.home.movies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tech.eightbits.home_ui.data.viewmodels.movies.MoviesViewModel

/**
 * Created by ozan on 8.01.2024
 */

@Composable
fun MoviesScreen(
    moviesViewModel: MoviesViewModel,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        PopularList(moviesViewModel, moviesViewModel::onEvent)

    }
}