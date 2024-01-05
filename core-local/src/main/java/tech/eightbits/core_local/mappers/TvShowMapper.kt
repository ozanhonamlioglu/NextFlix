package tech.eightbits.core_local.mappers

import tech.eightbits.core.models.TvShowResponse
import tech.eightbits.core_local.mylist_tvshows.MyListTvShowsEntity

/**
 * Created by ozan on 5.01.2024
 */

fun TvShowResponse.toMyListTvShowsEntity(): MyListTvShowsEntity = MyListTvShowsEntity(
    id,
    adult,
    backdrop_path,
    first_air_date,
    name,
    original_language,
    original_name,
    overview,
    popularity,
    poster_path,
    vote_average,
    vote_count
)