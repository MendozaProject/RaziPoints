package com.computersquid.razipoints.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.computersquid.razipoints.data.model.Task

interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAll(): List<Task>

    @Query("SELECT * FROM tasks WHERE id IN (:taskIds)")
    fun loadAllByIds(taskIds: IntArray): List<Task>

    @Insert
    fun insertAll(vararg tasks: Task)

    @Delete
    fun delete(task: Task)
}