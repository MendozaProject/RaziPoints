package com.computersquid.razipoints.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.computersquid.razipoints.data.dao.TaskDao
import com.computersquid.razipoints.data.dao.UserDao
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.User

@Database(entities = [User::class, Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao
}



