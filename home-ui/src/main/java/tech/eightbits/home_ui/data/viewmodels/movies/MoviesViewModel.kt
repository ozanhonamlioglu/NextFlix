package tech.eightbits.home_ui.data.viewmodels.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
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

    private val _popularList =
        MutableStateFlow<UiResponseDto<DataListResponse<MovieResponse>>>(UiResponseDto())
    val popularList = _popularList.asStateFlow()

//    private val _upComingList = MutableStateFlow<List<MovieResponse>>(emptyList())
//    val upComingList = _upComingList.asStateFlow()
//
//    private val _nowPlaying = MutableStateFlow<List<MovieResponse>>(emptyList())
//    val nowPlaying = _nowPlaying.asStateFlow()
//
//    private val _topRated = MutableStateFlow<List<MovieResponse>>(emptyList())
//    val topRated = _topRated.asStateFlow()

    private fun getMovieList(category: String, initial: Boolean) {
        val page = _movieListMeta[category]?.data?.let {
            it.page + 1
        } ?: 1

        if (page > 1 && initial) return; // We only call page 1 at initial load.

        viewModelScope.launch {
            listRepository.getMovieListByCategory(category, page)
                .collectLatest { latest ->
                    _movieListMeta[category] = latest

                    when (category) {
                        MovieApi.Category_Popular -> {
                            _popularList.update {
                                val data = if(it.data?.results != null)
                                    it.data!!.results + (latest.data?.results ?: emptyList())
                                else
                                    latest.data?.results ?: emptyList()

                                latest.copy(data = latest.data?.copy(results = data))
                            }
                        }

                        MovieApi.Category_Now_Playing -> Unit

                        MovieApi.Category_Top_Rated -> Unit

                        MovieApi.Category_Upcoming -> Unit
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