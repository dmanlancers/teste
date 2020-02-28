package pt.ren.mobile.investors.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ZUserDao {

    @Query("SELECT * FROM zuser")
    fun getAll(): List<ZUser>

    @Query("SELECT * FROM zuser WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<ZUser>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): ZUser

    @Insert
    fun insertAll(vararg users: ZUser)

    @Delete
    fun delete(user: ZUser)

}