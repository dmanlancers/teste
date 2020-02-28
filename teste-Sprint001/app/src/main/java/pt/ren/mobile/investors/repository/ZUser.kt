package pt.ren.mobile.investors.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ZUser (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val firstName: String?
   /* @ColumnInfo(name = "last_name") val lastName: String?*/



)