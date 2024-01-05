package tech.eightbits.core_local.mappers

import tech.eightbits.core.models.MovieResponse
import tech.eightbits.core_local.mylist_movie.MyListMovieEntity

/**
 * Created by ozan on 5.01.2024
 */

fun MovieResponse.toMyListMovieEntity(): MyListMovieEntity = MyListMovieEntity(
    id,
    adult,
    backdrop_path,
    original_language,
    original_title,
    overview,
    popularity,
    poster_path,
    release_date,
    title,
    video,
    vote_average,
    vote_count
)