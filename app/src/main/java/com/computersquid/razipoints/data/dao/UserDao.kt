package com.computersquid.razipoints.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.User
import androidx.room.RoomMasterTable.TABLE_NAME
import com.computersquid.razipoints.data.model.USER_TABLE_NAME


@Dao
interface UserDao {

    @Query("SELECT COUNT(*) FROM $USER_TABLE_NAME")
    fun count(): Int

    @Query("SELECT * FROM users")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getById(userId: Int): LiveData<User>

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Insert
    fun insert(vararg users: User)

    @Delete
    fun delete(user: User)

    @Update
    fun update(vararg users: User)
}