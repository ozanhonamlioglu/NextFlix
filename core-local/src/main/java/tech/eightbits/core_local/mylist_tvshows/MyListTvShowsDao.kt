package tech.eightbits.core_local.mylist_tvshows

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import tech.eightbits.core_local.mylist_movie.MyListMovieEntity

/**
 * Created by ozan on 4.01.2024
 */

@Dao
interface MyListTvShowsDao {

    @Upsert
    suspend fun upsetTvShow(show: MyListTvShowsEntity)

    @Query("SELECT * FROM MyListTvShowsEntity where id=:id")
    suspend fun getTVShowById(id: String): MyListTvShowsEntity

    @Query("SELECT * FROM MyListTvShowsEntity")
    suspend fun getTvShowList(): List<MyListTvShowsEntity>

}