package pt.ren.mobile.investors.repository

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ZUser::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): ZUserDao
}
