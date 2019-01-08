package com.computersquid.razipoints.data

import com.computersquid.razipoints.model.Task
import io.objectbox.BoxStore
import javax.inject.Inject

class TaskRepository : LocalRepository<Task> {

    @Inject
    constructor(boxStore: BoxStore): super(boxStore, Task::class.java) {

    }


    var tasks = emptyList<Task>()


    fun getById(id: Long): Task {
        return tasks.single { it.id == id }
    }


    fun addNewTask() {

    }


    fun updateTask(id: Long) {

    }


    companion object {
        @JvmStatic val TAG: String = this::class.java.simpleName
    }
}