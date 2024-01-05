package tech.eightbits.core_local.mylist_movie

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

/**
 * Created by ozan on 4.01.2024
 */

@Dao
interface MyListMovieDao {

    @Upsert
    suspend fun upsertMovie(movie: MyListMovieEntity)

    @Query("SELECT * FROM MyListMovieEntity where id=:id")
    suspend fun getMovieById(id: String): MyListMovieEntity

    @Query("SELECT * FROM MyListMovieEntity")
    suspend fun getMovieList(): List<MyListMovieEntity>

}