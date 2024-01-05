package tech.eightbits.core_local.mylist_movie

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by ozan on 4.01.2024
 */

@Database(
    entities = [MyListMovieEntity::class],
    version = 1
)
abstract class MyListMovieDatabase: RoomDatabase() {
    abstract val dao: MyListMovieDao
}