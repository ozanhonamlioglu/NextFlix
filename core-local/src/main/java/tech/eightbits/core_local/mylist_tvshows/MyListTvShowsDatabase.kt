package tech.eightbits.core_local.mylist_tvshows

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by ozan on 4.01.2024
 */

@Database(
    entities = [MyListTvShowsEntity::class],
    version = 1
)
abstract class MyListTvShowsDatabase: RoomDatabase() {
    abstract val dao: MyListTvShowsDao
}