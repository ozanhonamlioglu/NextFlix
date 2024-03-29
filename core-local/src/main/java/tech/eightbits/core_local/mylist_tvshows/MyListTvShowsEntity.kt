package tech.eightbits.core_local.mylist_tvshows

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyListTvShowsEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    val adult: Boolean,
    val backdrop_path: String,
    val first_air_date: String,
    val name: String,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int
)