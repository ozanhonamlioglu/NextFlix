package tech.eightbits.home_ui.domain.viewmodels.movies

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import tech.eightbits.core.models.MovieResponse

/**
 * Created by ozan on 16.01.2024
 */

typealias t_movie_list_map = MutableMap<String, MutableStateFlow<MovieResponse>>
typealias t_movie_flow = Flow<List<MovieResponse>>