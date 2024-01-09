package tech.eightbits.home_ui.pages.home.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import tech.eightbits.core_network.MovieApi
import tech.eightbits.home_ui.data.repository.ListRepository
import javax.inject.Inject

/**
 * Created by ozan on 9.01.2024
 */

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val listRepository: ListRepository
): ViewModel() {

    init {
        getMovieList()
    }

    private fun getMovieList() {
        viewModelScope.launch {
            listRepository.getMovieListByCategory(
                category = MovieApi.Category_Popular,
                page = 1
            ).collectLatest {

            }
        }
    }

}