package tech.eightbits.home_ui.data.viewmodels.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import tech.eightbits.core.models.DataListResponse
import tech.eightbits.core.models.MovieResponse
import tech.eightbits.core_network.MovieApi
import tech.eightbits.core_network.models.UiResponseDto
import tech.eightbits.core_ui.utils.UiEvent
import tech.eightbits.home_ui.data.repository.ListRepository
import javax.inject.Inject

/**
 * Created by ozan on 16.01.2024
 */

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val listRepository: ListRepository
) : ViewModel() {

    private var _movieListMeta =
        mutableMapOf<String, UiResponseDto<DataListResponse<MovieResponse>>>()

    private val _popularList = MutableStateFlow<List<MovieResponse>>(emptyList())
    val popularList = _popularList.asStateFlow()

    private val _upComingList = MutableStateFlow<List<MovieResponse>>(emptyList())
    val upComingList = _upComingList.asStateFlow()

    private val _nowPlaying = MutableStateFlow<List<MovieResponse>>(emptyList())
    val nowPlaying = _nowPlaying.asStateFlow()

    private val _topRated = MutableStateFlow<List<MovieResponse>>(emptyList())
    val topRated = _topRated.asStateFlow()

    private fun getMovieList(category: String, initial: Boolean) {
        val page = _movieListMeta[category]?.data?.let {
            it.page + 1
        } ?: 1

        if (page > 1 && initial) return; // We only call page 1 at initial load.

        viewModelScope.launch {
            listRepository.getMovieListByCategory(category, page)
                .collectLatest { latest ->
                    _movieListMeta[category] = latest // update the meta values of the category

                    latest.data?.results?.let { newList ->

                        when (category) {
                            MovieApi.Category_Popular -> {
                                val copiedData = _popularList.value.toMutableList()
                                copiedData.addAll(newList)
                                _popularList.value = copiedData
                            }

                            MovieApi.Category_Now_Playing -> {
                                val copiedData = _nowPlaying.value.toMutableList()
                                copiedData.addAll(newList)
                                _nowPlaying.value = copiedData
                            }

                            MovieApi.Category_Top_Rated -> {
                                val copiedData = _topRated.value.toMutableList()
                                copiedData.addAll(newList)
                                _topRated.value = copiedData
                            }

                            MovieApi.Category_Upcoming -> {
                                val copiedData = _upComingList.value.toMutableList()
                                copiedData.addAll(newList)
                                _upComingList.value = copiedData
                            }
                        }

                    }
                }
        }
    }

    fun onEvent(event: UiEvent) {
        when (event) {
            is UiEvent.MovieFetch -> getMovieList(event.category, event.initial)
            is UiEvent.TvShowFetch -> Unit
        }
    }

}