package com.computersquid.razipoints.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.computersquid.razipoints.data.model.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAll(): LiveData<List<Task>>

    @Query("SELECT * FROM tasks WHERE id = :taskId")
    fun getById(taskId: Int): LiveData<Task>

    @Query("SELECT * FROM tasks WHERE id IN (:taskIds)")
    fun loadAllByIds(taskIds: IntArray): LiveData<List<Task>>

    @Insert
    fun insertAll(vararg tasks: Task)

    @Delete
    fun delete(task: Task)

    @Update
    fun update(vararg tasks: Task)
}