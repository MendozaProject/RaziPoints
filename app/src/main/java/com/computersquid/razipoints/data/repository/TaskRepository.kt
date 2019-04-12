package com.computersquid.razipoints.data.repository
import androidx.lifecycle.LiveData
import com.computersquid.razipoints.data.dao.TaskDao
import com.computersquid.razipoints.data.model.Task
import javax.inject.Inject

class TaskRepository @Inject constructor(private val taskDao: TaskDao){

    init {
    }

    fun getAll(): LiveData<List<Task>> {
        return taskDao.getAll()
    }

    fun getById(id: Int): LiveData<Task> {
        return taskDao.getById(id)
    }

    fun add(task: Task) {
        taskDao.insert(task)
    }

    fun updateTask(task: Task) {
        taskDao.update(task)
    }
}