package com.computersquid.razipoints.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.computersquid.razipoints.data.model.User

interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}