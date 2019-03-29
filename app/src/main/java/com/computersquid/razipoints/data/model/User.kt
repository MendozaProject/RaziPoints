package com.computersquid.razipoints.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
        @PrimaryKey var id: Long = 0,
        @ColumnInfo(name = "name") var name: String,
        @ColumnInfo(name = "points") var points: Int
)